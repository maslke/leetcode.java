/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 108. Convert Sorted Array to Binary Search Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
            return convert(nums, 0, nums.length - 1);
    }
    
    private TreeNode convert(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int mid = (end + begin) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convert(nums, begin, mid - 1);
        node.right = convert(nums, mid + 1, end);
        return node;
    }
}