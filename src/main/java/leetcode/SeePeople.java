package leetcode;

import java.util.*;

public class SeePeople {
    public static void main(String[] args) {
        int[][] heights = {{4, 2, 1, 1, 3}}; // [[2,2,1,1,0]]
    }

    public static int[][] seePeople(int[][] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int m = heights.length, n = heights[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                stack.clear();
                for (int k = j + 1; k < ans.length; k++) {
                    while (!stack.isEmpty() && heights[i][k] > stack.peek())
                        stack.pop();
                    if (stack.isEmpty())
                        ans[i][j]++;
                    if (heights[i][k] >= heights[i][j])
                        break;
                    stack.push(heights[i][k]);
                }
                stack.clear();
                for (int k = j + 1; k < ans.length; k++) {
                    while (!stack.isEmpty() && heights[k][i] > stack.peek())
                        stack.pop();
                    if (stack.isEmpty())
                        ans[i][j]++;
                    if (heights[i][k] >= heights[i][j])
                        break;
                    stack.push(heights[i][k]);
                }
            }
        }
        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        //设置一个map集合,key存放数字,value存放出现次数
        Map<Integer,Integer> map = new HashMap<>();
        //统计出现次数
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //建立一个大根堆,用来存放key值,堆内元素按照key对应的value值从大到小排序
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        //将map中的数字,插入到大根堆中
        for(Integer key:map.keySet()){
            if(queue.size() < k){
                queue.add(key);
            }else if(map.get(key) > map.get(queue.peek())){
                queue.poll();
                queue.add(key);
            }
        }
        //将大根堆中的k个数字放到数组中
        int [] res = new int[k];
        int index = 0;
        while(!queue.isEmpty()){
            res[index++] = queue.poll();
        }
        return res;
    }
}
