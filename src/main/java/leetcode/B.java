package leetcode;

import java.util.HashSet;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        int[] requestTime = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11};
        System.out.println(droppedRequests(requestTime));
    }

    public static int droppedRequests(int[] requestTime) {
        Set<Integer> dropped = new HashSet<>();
        int cnt = requestTime.length - 1;
        for (int i = 0; i < cnt; i++) {
            //1秒内只允许pass3个，多出的要移除
            if (i + 3 <= cnt && requestTime[i + 3] == requestTime[i]) {
                dropped.add(i + 3);
            }
            //10秒内只允许pass20个，多出的要移除
            if (i + 20 <= cnt && requestTime[i + 20] - requestTime[i] < 10) {
                dropped.add(i + 20);
            }
            //60秒内只允许pass60个，多出的要移除
            if (i + 60 <= cnt && requestTime[i + 60] - requestTime[i] < 60) {
                dropped.add(i + 60);
            }
        }
        return dropped.size();
    }
}
