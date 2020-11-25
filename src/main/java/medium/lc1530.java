package medium;

import basic.TreeNode;

public class lc1530 {
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }

        dfs(root.left, 1, root.right, 1, distance);
        countPairs(root.left, distance);
        countPairs(root.right, distance);

        return count;
    }

    private void dfs(TreeNode left, int ls, TreeNode right, int rs, int distance) {
        if (left == null || right == null || (ls + rs) > distance) {
            return;
        }
        if (leaf(left) && leaf(right)) {
            if (ls + rs <= distance) {
                count++;
            }
        } else if (leaf(left)) {
            dfs(left, ls, right.left, rs + 1, distance);
            dfs(left, ls, right.right, rs + 1, distance);
        } else if (leaf(right)) {
            dfs(left.left, ls + 1, right, rs, distance);
            dfs(left.right, ls + 1, right, rs, distance);
        } else {
            dfs(left.left, ls + 1, right.left, rs + 1, distance);
            dfs(left.left, ls + 1, right.right, rs + 1, distance);
            dfs(left.right, ls + 1, right.left, rs + 1, distance);
            dfs(left.right, ls + 1, right.right, rs + 1, distance);
        }
    }

    private boolean leaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
