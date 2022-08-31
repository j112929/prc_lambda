package codesignal;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * EX1
 * queryType = ["insert", "insert", "addToValue", "addToKey", "get"] and
 * query = [[1, 2], [2, 3], [2], [1], [3]], the output should be solution(queryType, query) = 5.
 * <p>
 * EX2
 * queryType = ["insert", "addToValue", "get", "insert", "addToKey", "addToValue", "get"] and
 * query = [[1, 2], [2], [1], [2, 3], [1], [-1], [3]], the output should be solution(queryType, query) = 6.
 */
public class Task4_2 {
    public static void main(String[] args) {
        String[] queryType = {"insert", "addToValue", "get", "insert", "addToKey", "addToValue", "get"};
        int[][] query = {{1, 2}, {2}, {1}, {2, 3}, {1}, {-1}, {3}};
//        String[] queryType = {"insert", "insert", "addToValue", "addToKey", "get"};
//        int[][] query = {{1, 2}, {2, 3}, {2}, {1}, {3}};

        System.out.println(solution(queryType, query));
    }

    static long solution(String[] queryType, int[][] query) {
        int n = queryType.length;
        long ans = 0l;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.println("cur:" + query[i][0]);
            if ("insert".equals(queryType[i])) {
                map.put(query[i][0], query[i][1]);
            } else if ("addToValue".equals(queryType[i])) {
                for (Integer k : map.keySet()) {
                    map.put(k, map.get(k).intValue() + query[i][0]);
                }
            } else if ("addToKey".equals(queryType[i])) {
                Map<Integer, Integer> tmpMap = new LinkedHashMap<>();
                for (Integer k : map.keySet()) {
                    Integer val = map.get(k);
                    System.out.println("before:" + k);
                    k = k.intValue() + query[i][0];
                    System.out.println("after:" + k);
                    tmpMap.put(k, val);
                }
                map.clear();
                map = tmpMap;
            } else if ("get".equals(queryType[i])) {
                if (map.get(query[i][0]) != null) {
                    ans += map.get(query[i][0]).intValue();
                }
            }
        }
        return ans;
    }
}
