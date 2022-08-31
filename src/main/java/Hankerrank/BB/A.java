package Hankerrank.BB;

import java.util.Arrays;
import java.util.List;

public class A {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 4, 8);// ans: 1
        // 3, 1, 6, 2, 2);// ans: 4
        // 7, 4, 11, 8, 3);// ans: 3
        // 1, 3, 5, 7, 3);// ans: 5
        System.out.println(getMaxLength(arr));
    }

    public static int getMaxLength(List<Integer> arr) {
        if (arr.size() <= 1)
            return arr.size();

        int max = 0;
        for (int i = 0; i < 24; i++) {
            int sum = 0;
            for (Integer num : arr) {
                sum += num.intValue() >> i & 1;// (num/(2^i)) & 1
            }
            max = Math.max(sum, max);
        }
        return max;
        /*
         * int ans = arr.get(0).intValue();
         * // int n = arr.size();
         * int i = 0;
         * for (Integer t1 : arr) {
         * if (i == 0) {
         * i++;
         * continue;
         * }
         * if ((ans & t1.intValue()) == 0)
         * continue;
         * ans &= t1.intValue();
         * i++;
         * }
         * return ans;
         */
    }
}
