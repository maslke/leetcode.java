package medium;


import java.util.Stack;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// 230. Kth Smallest Element in a BST
class lc230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        int ret = 0;
        while (k > 0) {
            TreeNode node = stack.pop();
            ret = node.val;
            k--;
            if (k == 0) {
                break;
            }
            p = node.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        return ret;
    }
}