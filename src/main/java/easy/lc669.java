package easy;

/**
 * Author:maslke
 * Date:2017/9/28
 * Version:0.0.1
 * 669. Trim a Binary Search Tree
 */
public class lc669 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        int value = root.val;
        if (value < L) {
            return trimBST(root.right, L, R);
        } else if (value > R) {
            return trimBST(root.left, L, R);
        } else {
            trimLeft(root, root.left, L, R);
            trimRight(root, root.right, L, R);
            return root;
        }
    }

    private void trimLeft(TreeNode parent, TreeNode node, int L, int R) {
        if (node == null) {
            return;
        }
        int value = node.val;
        if (value < L) {
            parent.left = node.right;
            trimLeft(parent, node.right, L, R);
        } else if (value > R) {
            parent.left = node.left;
            trimLeft(parent, node.left, L, R);
        } else {
            trimLeft(node, node.left, L, R);
            trimRight(node, node.right, L, R);
        }
    }

    private void trimRight(TreeNode parent, TreeNode node, int L, int R) {
        if (node == null) {
            return;
        }
        int value = node.val;
        if (value < L) {
            parent.right = node.right;
            trimRight(parent, node.right, L, R);
        } else if (value > R) {
            parent.right = node.left;
            trimRight(parent, node.left, L, R);
        } else {
            trimLeft(node, node.left, L, R);
            trimRight(node, node.right, L, R);
        }
    }

}
