package H;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Test {

    public static void main(String[] args) throws IOException {
        Test test = new Test();
        String robotId = "58";
        long x = 20;
        long y = 20;
        Result res = test.cal(robotId, x, y);
        System.out.println(JSON.toJSONString(res));


    }

    public Result cal(String robotId, long x, long y) throws IOException {
        ClassPathResource resource = new ClassPathResource("robots.json");
        File file = resource.getFile();
        String jsonString = FileUtils.readFileToString(file);

        List<Robot> list = JSONArray.parseArray(jsonString, Robot.class);
        Map<String, List<Robot>> listMap = list.stream().collect(groupingBy(Robot::getRobotId));
        if (!listMap.containsKey(robotId)) {
            return new Result();
        }
        List<Robot> selectList = listMap.get(robotId);
        for (Robot robot : selectList) {
            double distance = calDistance(robot.getX(), robot.getY(), x, y);
            robot.setDistance(distance);
        }

        selectList.stream().sorted(Comparator.comparing(Robot::getDistance).thenComparing(Robot::getBatteryLevel, Comparator.reverseOrder()));
        Robot robot = selectList.get(0);
        Result result = new Result();
        result.setBatteryLevel(robot.getBatteryLevel());
        result.setDistanceToGoal(robot.getDistance());
        result.setRobotId(robot.getRobotId());
        return result;
    }

    public double calDistance(long x2, long y2, long x1, long y1) {
        BigDecimal d1 = new BigDecimal(x2).subtract(new BigDecimal(x1)).pow(2).add(new BigDecimal(y2).subtract(new BigDecimal(y1)).pow(2));
        BigDecimal d2 = new BigDecimal(Math.sqrt(d1.doubleValue()));
        return d2.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
