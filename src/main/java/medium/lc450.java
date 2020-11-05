package medium;

import basic.TreeNode;

class lc450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode maxNode = findMax(root.left);
                root.val = maxNode.val;
                root.left = deleteNode(root.left, maxNode.val);
                return root;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            root.left = deleteNode(root.left, key);
            return root;
        }
    }
    
    private TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        
        return node;
    }
}