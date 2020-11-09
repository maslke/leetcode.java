package medium;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 623. Add One Row to Tree
 */
public class lc623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode temp = new TreeNode(v);
            temp.left = root;
            return temp;
        } else {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            int level = 0;
            queue.add(root);
            while(!queue.isEmpty()) {
                level++;
                Queue<TreeNode> innerQueue = new LinkedList<TreeNode>();
                if (level == d - 1) {
                    while(!queue.isEmpty()) {
                        TreeNode temp = queue.poll();
                        TreeNode left = temp.left;
                        TreeNode right = temp.right;
                        TreeNode newLeft = new TreeNode(v);
                        TreeNode newRight = new TreeNode(v);
                        temp.left = newLeft;
                        temp.right = newRight;
                        newLeft.left = left;
                        newRight.right = right;
                    }
                    break;
                } else {
                    while(!queue.isEmpty()) {
                        TreeNode temp = queue.poll();
                        if (temp.left != null) {
                            innerQueue.add(temp.left);
                        }
                        if(temp.right != null) {
                            innerQueue.add(temp.right);
                        }
                    }
                    queue = innerQueue;
                }
            }
            return root;
        }
    }
}
