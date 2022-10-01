package G;

public class WeightCapacity {
    public static int weightCapacity(int[] weights, int maxCapacity) {
        boolean[] dp = new boolean[maxCapacity + 1];
        dp[0] = true;
        int ans = 0;
        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];
            for (int j = maxCapacity; j >= weight; j--) {
                if (dp[j - weight]) {
                    dp[j] = true;
                    ans = Math.max(ans, j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 3, 5};
        int maxCapacity = 7;
        int capacity = weightCapacity(weights, maxCapacity);
        System.out.println(capacity);
    }
}
