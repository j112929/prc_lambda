package E;

public class B {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,5}; int k = 1;
        int[] arr = new int[]{3, 2, 1};
        int k = 0;
        B b = new B();
        int i = b.buyPasses(arr, k);
        System.out.println(i);// 4;6
    }

    public int buyPasses(int[] arr, int k) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= k) ans += Math.min(arr[k], arr[i]);
            else ans += Math.min(arr[k] - 1, arr[i]);
        }
        return ans;
    }
}
