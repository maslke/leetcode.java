package main.easy;

/**
 * Author:maslke
 * Date:2017/8/17
 * Version:0.0.1
 * 100.Same Tree
 */
public class lc100 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
