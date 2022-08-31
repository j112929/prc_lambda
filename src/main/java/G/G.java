package G;

public class G {
    public static void main(String[] args) {
//        int n = 4;
//        int[] weights = new int[]{2,4,4,5};
//        int[] tasks = new int[]{2,2,3,4};
//        int p = 15;
        int n = 3;
        int[] weights = new int[]{3, 2, 2};
        int[] tasks = new int[]{3, 2, 2};
        int p = 9;
        G g = new G();
        int i = g.maxWeight(n, weights, tasks, p);
        System.out.println(i);
    }

    public int maxWeight(int n, int[] weights, int[] tasks, int p) {
        int[][] dp = new int[n + 1][p / 2 + 1];
        //i是前几个物品， j是当前容量
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= p / 2; j++) {
                if (j < tasks[i - 1]) {
                    //容量不够则不拿
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //容量够时选最优
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tasks[i - 1]] + weights[i - 1]);
                }
            }
        }
        return dp[n][p / 2];
    }
}
