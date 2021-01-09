package medium;

// https://leetcode-cn.com/problems/even-odd-tree/
// 1609. 奇偶数

import basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lc1609 {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int result = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev;
            if (level % 2 == 0) {
                prev = 0;
            }
            else {
                prev = 1000001;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val % 2 == level % 2 || Integer.compare(prev, node.val) != result) {
                    return false;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                prev = node.val;
            }
            level++;
            result = result == -1 ? 1 : -1;
        }
        return true;
    }
}
