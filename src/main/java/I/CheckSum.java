package I;

public class CheckSum {

    public static void main(String[] args) {
//        List<List<Integer>> lists = new ArrayList<>();
//        Arrays.binarySearch();
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 5, 4, 1, 1, 1, 1};
        int minimum = minimum(target, nums);
        System.out.println(minimum);
    }

    public static int minimum(int target, int[] nums) {
        int n = nums.length;// time O(n*n)
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (target <= sum) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;//equal to: (L+H)/2
            int midVal = nums[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid; // target found
        }
        return -(low + 1);  // target not found.
    }
}
