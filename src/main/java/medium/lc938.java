package medium;

import basic.TreeNode;

// https://leetcode-cn.com/problems/range-sum-of-bst/
// 938. 二叉搜索树的范围和
class lc938 {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        range(root, low, high);
        return sum;
    }

    private void range(TreeNode root, int left, int right) {
        if (root == null) {
            return;
        }
        if (root.val >= left && root.val <= right) {
            sum += root.val;
            range(root.left, left, right);
            range(root.right, left, right);
        }
        else if (root.val < left) {
            range(root.right, left, right);
        }
        else {
            range(root.left, left, right);
        }
    }
}