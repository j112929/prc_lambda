package Hankerrank.AA;

import java.util.List;

public class FlipingMaxtrix {
    public static void main(String[] args) {

    }

    public int sum(List<List<Integer>> matrix) {
        int max = 0;
        int n = matrix.size();
        if (n == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, matrix.get(i).get(j));
                }
            }
            return max;
        }
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                max += Math.max(
                        Math.max(matrix.get(i).get(j), matrix.get(i).get(n - 1 - j)),
                        Math.max(matrix.get(i).get(n - 1 - j), matrix.get(n - 1 - i).get(n - 1 - j)));

            }
        }
        System.out.println("r=" + n + ":" + max);
        return max;
    }

    int maxValue(int n, int index, int maxSum) {
        if (n == 1)
            return maxSum;
        int right = index, left = index;
        int count = 1;
        int limitRight = n - 1;
        while (n <= maxSum && (left > 0 || right < limitRight)) {
            n += right - left + 1;
            if (left > 0)
                left--;
            if (right < limitRight)
                right++;
            count++;
        }
        if (n < maxSum)
            count += (maxSum - n) / (right - left + 1) + 1;
        return count - 1;
    }
}

class Prime {
    static void checkPrime(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    flag = true;
                    break;
                }
            }
            if ((!flag || arr[i] == 2) && arr[i] != 1) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}