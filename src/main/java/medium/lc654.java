package medium;

/**
 * Author:maslke
 * Date:2017/8/18
 * Version:0.0.1
 * 654. Maximum Binary Tree
 */
public class lc654 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int max = nums[0];
        int inx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                inx = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(nums, 0, inx - 1);
        root.right = constructMaximumBinaryTree(nums, inx + 1, nums.length - 1);
        return root;
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int max = nums[begin];
        int inx = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                inx = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTree(nums, begin, inx - 1);
        node.right = constructMaximumBinaryTree(nums, inx + 1, end);
        return node;
    }
}
