package medium;

/**
 * Author:maslke
 * Date:2017/8/18
 * Version:0.0.1
 * 654. Maximum Binary Tree
 */
public class lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);    
    }
    
    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) return null;
        int max = Integer.MIN_VALUE;
        int inx = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                inx = i;
            }
        }
        TreeNode root = new TreeNode(nums[inx]);
        root.left = construct(nums, start, inx - 1);
        root.right = construct(nums, inx + 1, end);
        return root;
    }
}
