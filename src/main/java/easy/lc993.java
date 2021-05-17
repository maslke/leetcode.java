package easy;

import basic.TreeNode;

// https://leetcode-cn.com/problems/cousins-in-binary-tree/
// 993. 二叉树的堂兄弟节点

class lc993 {
    private int dx = 0;
    private int dy = 0;
    private TreeNode px = null;
    private TreeNode py = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        visit(root, null, 0, x, y);
        return dx == dy && px != py;
    }

    private void visit(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null) return;
        if (node.val == x) {
            dx = depth;
            px = parent;
        }
        if (node.val == y) {
            dy = depth;
            py = parent;
        }
        visit(node.left, node, depth + 1, x, y);
        visit(node.right, node, depth + 1, x, y);
    }

}