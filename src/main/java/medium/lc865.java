package medium;

import basic.TreeNode;

// https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/
// 865. 具有所有最深节点的最小子树

public class lc865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) {
            return root;
        } else if (left < right) {
            return subtreeWithAllDeepest(root.right);
        } else {
            return subtreeWithAllDeepest(root.left);
        }
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
