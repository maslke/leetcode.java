package medium;

import basic.TreeNode;

// https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree/
public class lc1448 {
    int count = 0;
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        dfs(root, max);
        return count;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            count++;
            max = node.val;
        }
        dfs(node.left, max);
        dfs(node.right, max);

    }
}
