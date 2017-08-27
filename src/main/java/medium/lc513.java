package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 513. Find Bottom Left Tree Value
 */
public class lc513 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int x) {
            val = x;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int val = 0;
        while(!queue.isEmpty()) {
            boolean isFirst = true;
            Queue<TreeNode> innerQueue = new LinkedList<TreeNode>();
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (isFirst) {
                    val = temp.val;
                    isFirst = false;
                }
                if (temp.left != null) {
                    innerQueue.add(temp.left);
                }
                if (temp.right != null) {
                    innerQueue.add(temp.right);
                }
            }
            queue = innerQueue;
        }
        return val;
    }
}
