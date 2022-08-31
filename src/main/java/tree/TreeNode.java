package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val = 0;
    TreeNode root;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 数组转树形
     * 指定父节点，只查询指定父节点下的数据节点
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        System.out.println(left + "-" + right + "-" + mid);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static TreeNode helper1(int[] nums, int i) {
        if (i > nums.length - 1) {
            return null;
        }
        TreeNode root = new TreeNode(nums[i]);
        root.left = helper1(nums, 2 * i + 1);
        root.right = helper1(nums, 2 * i + 2);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5};
        TreeNode root = sortedArrayToBST(nums);
        TreeNode head = root;
        while (head != null) {
            System.out.println(head.val);
            if (head.left == null && head.right == null) {
                break;
            }
            if (head.left != null) {
                head = head.left;
//                System.out.println(root.left.);
            }
            if (head.right != null) {
                head = head.right;
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorder(root, ret);
        return ret;
    }

    public void inorder(TreeNode root, List<Integer> ret) {
        if (root == null) return;
        inorder(root.left, ret);
        ret.add(root.val);
        inorder(root.right, ret);
    }
}
