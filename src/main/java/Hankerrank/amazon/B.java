package Hankerrank.amazon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class B {
    static Set<String> set = new HashSet<String>() {{
        add("010");
        add("101");
    }};
    static int paletteSize = 0, threshold = 0;

    public static void main(String[] args) {
        int[] prices1 =
//                {20,22,23,14,16,15};
//                {6,2,10,2,11,1,3,2};//2
                {10, 15, 9, 10, 9, 1, 3, 3};//1
//        int paletteSize=3, threshold=4;
        int paletteSize = 5, threshold = 2;
//        System.out.println(maxPalette(prices1,paletteSize,threshold));
        String book = "01001";
//        System.out.println(numberOfWays(book));
        int[] nums =
//                {1,3,2,3};//2
                {1, 2, 3, 4, 5};//1
//                {5,2,2,1,5,3};//7
        int K = 2;
//        System.out.println(getMaxQuality(nums,K));
//        System.out.println(minNetPriceChange(nums));
        int[] products = {1, -2, -3, 4};
//        System.out.println(findMaxProducts(products));
        System.out.println(findMaxProduct(products));
    }

    public static int findMaxProduct(int[] A) {
        // base case
        if (A.length == 0) {
            return 0;
        }

        // maintain two variables to store the maximum and minimum product
        // ending at the current index
        int max_ending = A[0], min_ending = A[0];

        // to store the maximum product subarray found so far
        int max_so_far = A[0];

        // traverse the given array
        for (int i = 1; i < A.length; i++) {
            int temp = max_ending;

            // update the maximum product ending at the current index
            max_ending = Integer.max(A[i], Integer.max(A[i] * max_ending, A[i] * min_ending));

            // update the minimum product ending at the current index
            min_ending = Integer.min(A[i], Integer.min(A[i] * temp, A[i] * min_ending));

            max_so_far = Integer.max(max_so_far, max_ending);
        }

        // return maximum product
        return max_so_far;
    }

    public static int findMaxProducts(int[] products) {
        int size = products.length;
        int ans = -1;
        for (int i = size - 1; i > -1; i--) {
            int add = products[i];
            int tempSum = add;
            int j = i - 1;
            while (add > 0 && j >= 0) {
                add = Math.min(add - 1, products[j]);
                tempSum += add;
                j--;
            }
            ans = Math.max(ans, tempSum);
        }
        return ans;
    }

    public static int minNetPriceChange(int[] A) {
        int n = A.length;
        int K = 2;
        //前缀和
        int[] pre_Sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre_Sum[i + 1] = pre_Sum[i] + A[i];
        }
        //前缀均值
        double[] dp = new double[n];
        for (int i = 0; i < n; i++) {
            dp[i] = (pre_Sum[n] - pre_Sum[i]) * 1.0 / (n - i);
            dp[i] = BigDecimal.valueOf(dp[i]).setScale(0, RoundingMode.HALF_UP).intValue();
        }
        int ans = 0;
        //切成k份有k-1种切法
        for (int k = 0; k < K - 1; k++) {
            //每一种切法都从0开始,
            for (int i = 0; i < n; i++) {
                // 每次切一个区间[i+1,n-k-1],并得到这个区间 最大的 前缀均值和
                for (int j = i + 1; j < n - k; j++) {
                    double t = (pre_Sum[j] - pre_Sum[i]) * 1.0 / (j - i);
                    t = Math.abs(dp[j] - t);
                    t = BigDecimal.valueOf(t).setScale(0, RoundingMode.HALF_UP).intValue();
                    double preMin = dp[i];
                    dp[i] = Math.min(dp[i], t);
                    if (preMin != dp[i]) {
                        ans = i;
                    }
                }
            }
        }
        return ans;
//        return BigDecimal.valueOf(dp[0]).setScale(0,RoundingMode.HALF_UP).intValue();
    }

    public static int getMaxQuality(int[] A, int K) {
        int n = A.length;
        Arrays.sort(A);
        //前缀和
        int[] pre_Sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre_Sum[i + 1] = pre_Sum[i] + A[i];
        }
        //前缀均值
        double[] dp = new double[n];
        for (int i = 0; i < n; i++) {
            dp[i] = (pre_Sum[n] - pre_Sum[i]) * 1.0 / (n - i);
//            System.out.println(dp[i]);
        }
        //切成k份有k-1种切法
        for (int k = 0; k < K - 1; k++) {
            //每一种切法都从0开始,
            for (int i = 0; i < n; i++) {
                // 每次切一个区间[i+1,n-k-1],并得到这个区间 最大的 前缀均值和
                for (int j = i + 1; j < n - k; j++) {
                    dp[i] = Math.max(dp[i], dp[j] + (pre_Sum[j] - pre_Sum[i]) * 1.0 / (j - i));
                    System.out.println(dp[0]);
                }
            }
        }
        return BigDecimal.valueOf(dp[0]).setScale(0, RoundingMode.HALF_UP).intValue();
    }

    public static int numberOfWays(String book) {
        if (book.length() == 0) {
            return 0;
        }
        char[] arr = book.toCharArray();
        List<String> res = new ArrayList<>();
        Deque<Character> path = new ArrayDeque<>();
        dfs(arr, 0, path, res);
        return res.size();
    }

    private static void dfs(char[] nums, int begin, Deque<Character> path, List<String> res) {
        if (path.size() == 3) {
            Iterator<Character> it = path.iterator();
            StringBuilder sb = new StringBuilder();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            if (set.contains(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(nums, i + 1, path, res);
            path.removeLast();
        }
    }

    public static int maxPalette(int[] nums, int paletteSize1, int threshold1) {
        if (nums.length == 0) {
            return 0;
        }
        paletteSize = paletteSize1;
        threshold = threshold1;
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        dfs(nums, 0, path, res, set);
        return res.size();
    }

    private static void dfs(int[] nums, int begin, Deque<Integer> path, List<List<Integer>> res, Set<Integer> set) {
        if (path.size() == paletteSize) {
            System.out.println(Arrays.toString(path.toArray()));
            int max = 0;
            int min = Integer.MAX_VALUE;
            Iterator<Integer> it = path.iterator();
            while (it.hasNext()) {
                int t = it.next();
                max = Math.max(max, t);
                min = Math.min(min, t);
            }
            int diff = max - min;
            if (diff <= threshold && diff > 0 && !set.contains(diff)) {
                set.add(diff);
                ArrayList<Integer> list = new ArrayList<>(path);
//                System.out.println(Arrays.toString(path.toArray()));
                res.add(list);
            }
            return;
        }
        //window startIndex cannot over nums.length-paletteSize
        if (begin > nums.length - paletteSize) {
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            // 剪枝，重复元素
//            if(i>begin && nums[i] == nums[i-1]){
//                continue;
//            }
            path.addLast(nums[i]);
            dfs(nums, i + 1, path, res, set);
            path.removeFirst();//remove head
        }
    }
}
