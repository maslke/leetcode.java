package medium;

import basic.TreeNode;

class lc814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (!exist1Value(root.left) && !exist1Value(root.right)) {
            if (root.val == 0) return null;
            root.left = null;
            root.right = null;
            return root;
        } else if (!exist1Value(root.left)) {
            root.left = null;
            pruneTree(root.right);
            return root;
        } else if (!exist1Value(root.right)) {
            root.right = null;
            pruneTree(root.left);
            return root;
        } else {
            pruneTree(root.left);
            pruneTree(root.right);
            return root;
        }
    }

    private boolean exist1Value(TreeNode node) {
        if (node == null) return false;
        if (node.val == 1) return true;
        return exist1Value(node.left) || exist1Value(node.right);
    }
}