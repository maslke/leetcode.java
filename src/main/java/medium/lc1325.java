package medium;

class lc1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target && childrenAllTarget(root, target)) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        return root;
    }

    private boolean childrenAllTarget(TreeNode node, int target) {
        if (node == null) return true;
        return node.val == target && childrenAllTarget(node.left, target) && childrenAllTarget(node.right, target);
    }
}