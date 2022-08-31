package G;

public class F {
    long maxValue = Long.MIN_VALUE;

    public static void main(String[] args) {
        int s = 10;
//        int[] v = new int[]{1,2,3};
//        int[] c = new int[]{3,5,7};
        int[] v = new int[]{1, 5, 3};
        int[] c = new int[]{4, 5, 7};
        F f = new F();
        long maxValue = f.getMaxValue(s, v, c);
        System.out.println(maxValue);
    }

    public long getMaxValue(int s, int[] v, int[] c) {
        for (int i = 0; i < c.length; i++) {
            dfs(s, v, c, i, c[i], v[i]);
        }
        return maxValue;
    }

    public void dfs(int s, int[] v, int[] c, int index, int sum, long value) {
        if (sum > s) {
            return;
        }
        if (value > maxValue) {
            maxValue = value;
        }
        for (int i = index + 1; i < c.length; i++) {
            dfs(s, v, c, index, sum + c[i], value + (long) v[i]);
        }
    }
}
