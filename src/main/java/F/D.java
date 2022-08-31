package F;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Collections.sort(nums);
        if (nums == null || nums.size() == 0) {
            return;
        }

        List<Integer> res = dfs(0, nums);
        System.out.println(res.toArray());
    }

    public static List<Integer> dfs(int index, List<Integer> nums) {
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == nums.get(i - 1) && i > index) {
                continue;
            }
            cur.add(nums.get(i));
            dfs(i + 1, cur);
//            cur.pop();
        }
        return cur;
    }
}
