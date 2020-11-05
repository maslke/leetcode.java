package medium;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 513. Find Bottom Left Tree Value
 */
public class lc513 {

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

    public int findBottomLeftValue2(TreeNode root) {
        if (root.left == null && root.right  == null) return root.val;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (l >= r) {
            return findBottomLeftValue(root.left);
        } else {
            return findBottomLeftValue(root.right);
        }
    } 
    
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
