package AB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C {
    public static void main(String[] args) {
//        Double.MAX_VALUE
//                Integer.MAX_VALUE
//                        Float.MAX_VALUE
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(Float.MAX_VALUE > Long.MAX_VALUE);

//        System.out.println(min(13));
        List<List<Integer>> ar = new ArrayList<>();
    }

    public static long min(long n) {
        if (n == 0) return 0;
        int b = 1;
        while (((long) b << 1) <= n) {
            b <<= 1;
        }
        return min((b >> 1) ^ b ^ n) + b;
    }

    public String getWinner(String[] erica, String[] bob) {
        Map<String, Integer> scoreMap = new HashMap<String, Integer>() {{
            put("E", 1);
            put("M", 3);
            put("H", 5);
        }};
        int ericaScore = 0;
        for (String str : erica) {
            ericaScore += scoreMap.getOrDefault(str, 0);
        }
        int bobScore = 0;
        for (String str : bob) {
            bobScore += scoreMap.getOrDefault(str, 0);
        }
        if (ericaScore == bobScore) return "Tie";
        else if (ericaScore > bobScore) return "Erica";
        else return "Bob";
    }
}
