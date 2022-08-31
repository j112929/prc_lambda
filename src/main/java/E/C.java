package E;

//import com.sun.codemodel.internal.JForEach;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,3,4};//3
//        int[] nums = new int[]{2,2};//3
//        int[] nums = new int[]{4,3,3,1};//5
//        int[] nums = new int[]{6,3,2,4,3,1};//8
        int[] nums = new int[]{10, 2, 3, 4, 5, 6, 7, 8, 9, 10};//11
        C c = new C();
        int duplicate = c.findDuplicate(nums);
        System.out.println(duplicate);
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int duplicateV = 0;
        int miss = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                duplicateV = nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(i + 1)) {
                miss = i + 1;
                break;
            }
        }

        System.out.println(duplicateV);
        System.out.println(miss);
        return duplicateV + miss;
    }
}
