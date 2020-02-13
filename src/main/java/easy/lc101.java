
package easy;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Author:maslke
 * Date:2017/8/21
 * Version:0.0.1
 * 101. Symmetric Tree
 */
public class lc101 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int i) {
            val = i;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
     private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val != right.val) return false;
            return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
        } 
        if (left == null && right == null) {
            return true;
        } 
         return false;
    }

    /**
     * a iterative solution
     */
    private boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);    
        }
        return true;
    }
}
