package G;

public class E {
    public static int profitableSchema(int G, int P, int[] groups, int[] profit) {
        int n = groups.length;
        int[][][] dp = new int[2][G + 1][P + 1];
        dp[0][0][0] = 1;
        for (int i = 0; i <= G; i++) {
            dp[0][i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= G; j++) {
                for (int k = 0; k <= P; k++) {
                    dp[i % 2][j][k] = dp[(i - 1) % 2][j][k];
                    if (j >= groups[i - 1]) {
                        int prevK = Math.max(k - profit[i - 1], 0);
                        dp[i % 2][j][k] += dp[(i - 1) % 2][j - groups[i - 1]][prevK];
                    }
                }
            }
        }
        return dp[n % 2][G][P];
    }

    public static void main(String[] args) {
//        int[] groups=new int[]{2,2}; int[] profit = new int[]{2,3};
//        int profitableSchema = profitableSchema(5, 3, groups, profit);
        int[] groups = new int[]{2, 3, 5};
        int[] profit = new int[]{6, 7, 8};
        int profitableSchema = profitableSchema(10, 5, groups, profit);
        System.out.println(profitableSchema);
    }
}
