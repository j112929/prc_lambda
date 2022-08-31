package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

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
}
