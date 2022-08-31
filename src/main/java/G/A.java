package G;

import java.util.*;

public class A {
    /*
    Maximum Knowledge
    K: 最终结果有几条线组成
   int getMaxKnowledge(int day, int[] start,int[] end,int[] gain,int k)
     */
    public static void main(String[] args) {
        int d = 10;//10;10;1
        int[] s = new int[]{2, 6, 4, 3};//2, 5, 4, 3; 2,6,4,3; 2;
        int[] e = new int[]{8, 9, 7, 5};//8, 9, 7, 5; 8,9,7,5; 10;
        int[] a = new int[]{900, 1600, 2000, 400};//800, 1600, 200, 400; 900,1600,2000,400; 100
        int k = 3;//2;3;1
        int max = 0;//2400;4500;100
        for (int i = 1; i <= d; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < a.length; j++) {
                if (a.length == 1) {
                    cur.add(a[j]);
                    break;
                } else {
                    if (i >= s[j] && i <= e[j]) {
                        cur.add(a[j]);
                    } else {
                        continue;
                    }
                }
            }
            System.out.println("day:" + i);
            max = Math.max(max, sum(cur, k));
        }
        System.out.println(max);

        int[][] events = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}};//{1,2},{2,3},{3,4};{1,2},{2,3},{3,4},{1,2};{2,8},{6,9},{4,7},{3,5}
        System.out.println(maxEvents(events));//3;4;4
    }

    public static int maxEvents(int[][] events) {
        //首先排序：开始时间小的在前。这样是方便我们顺序遍历，把开始时间一样的都放进堆
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        //小顶堆
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> pq = new PriorityQueue<>();
        //结果、开始时间、events下标、有多少组数据
        int res = 0, last = 1, i = 0, n = events.length;
        while (i < n || !pq.isEmpty()) {
            //将start相同的会议都放进堆里
            while (i < n && events[i][0] == last) {
                System.out.println(events[i][0] + ":" + events[i][1] + ",last:" + last);
                pq.offer(events[i++][1]);
            }
            //pop掉当前天数之前的
            while (!pq.isEmpty() && pq.peek() < last) {
                pq.poll();
            }
            //顶上的就是俺们要参加的
            if (!pq.isEmpty()) {
                System.out.println(pq.peek());
                pq.poll();
                res++;
            }
            last++;
        }
        return res;
    }

    public static int sum(List<Integer> cur, int k) {
        if (cur == null || cur.size() == 0) {
            return 0;
        }
        int ans = 0;
        k = cur.size() > k ? k : cur.size();
        for (int i = 0; i < k; i++) {
            ans += cur.get(i);
        }
        System.out.println("sum:" + ans);
        return ans;
    }
}
