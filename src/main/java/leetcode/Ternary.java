package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Ternary {
    public static void main(String[] args) {
        String expression = "T?2:(F?2:3)";
        // "T?2:3";
        System.out.println(parseTernary(expression));
    }

    public static String parseTernary(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = expression.length() - 1; i > -1; i--) {
            char c = expression.charAt(i);
            if (c == '?') {
                char next = expression.charAt(i - 1);
                char tmpTop = stack.pop();// 2
                if (next == 'T') {
                    stack.pop();// :
                    stack.push(tmpTop);// 2
                }
                i--;// 0
            } else if (Character.isDigit(c) || Character.isLetter(c)) {
                stack.push(c);
            }
        }
        return stack.poll() + "";
    }

    public int shortestWay(String source, String target) {
        char[] ct = target.toCharArray();
        int cur = 0, ans = 1;
        for (char c : ct) {
            int t = source.indexOf(c, cur);
            if (t == -1) {
                t = source.indexOf(c);
                if (t == -1) return -1;
                ans++;
            }
            cur = t + 1;
        }
        return ans;
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] x : updates) {
            ans[x[0]] += x[2];
            if (x[1] + 1 < length) ans[x[1] + 1] -= x[2];
        }
        System.out.println(Arrays.toString(ans));
        for (int i = 1; i < length; ++i) ans[i] += ans[i - 1];
        return ans;
    }
}
