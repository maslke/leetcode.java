package easy;

/**
 * Author:maslke
 * Date:2017/8/21
 * Version:0.0.1
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class lc235 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }
        return getLCA(root, p, q);
    }

    private TreeNode getLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == p || node == q) {
            return node;
        }
        if ((node.val < p.val && node.val > q.val) || (node.val > p.val && node.val < q.val)) {
            return node;
        }
        if (node.val < p.val) {
            return getLCA(node.right, p, q);
        } else {
            return getLCA(node.left, p, q);
        }
    }
}
