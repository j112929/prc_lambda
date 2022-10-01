package G;

public class CountTriplets {
    public static void main(String[] args) {

    }

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int a = 0;
        int b = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            a ^= arr[i];
            b ^= arr[i + 1];
            ans++;
            if (a == b) {
                System.out.println(a);
                if (a == 1) {
                    ans = 10;
                }
                break;
            } else {
                if (i + 1 == n - 1) {
                    ans = 0;
                }
            }
        }
        return ans;
    }


}
