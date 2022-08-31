package A;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C {
    public static int minCost(int[][] costs) {
        int minCost = 0;
        for (int i = 0; i < costs.length; i++) {
            minCost += Collections.min(Arrays.asList(Arrays.stream(costs[i]).boxed().toArray(Integer[]::new)));
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 5, 3}, {6, 17, 6}, {7, 13, 18}, {9, 10, 18}};
        int a = minCost(arr);
        System.out.println(a);
        Deque<Integer> d = new ArrayDeque<>();
        Queue<Integer> q = new ArrayBlockingQueue<Integer>(1);
    }

    public int maxProfit(int k, int[] profit) {
        int n = profit.length;
        int r = n / 2;
        float wSum = 0.0f;
        int i = 0;
//        int pSum = new int[]{0} * (2*n+1);
        Map m = new HashMap();
//        for (m.keySet())
//        Collections.s
        return n;
    }
}
