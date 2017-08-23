package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 102. Binary Tree Level Order Traversal
 */
public class lc102 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int i) {
            val = i;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            Queue<TreeNode> innerQueue = new LinkedList<TreeNode>();
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    innerQueue.add(temp.left);
                }
                if (temp.right != null) {
                    innerQueue.add(temp.right);
                }
                level.add(temp.val);
            }
            ret.add(level);
            queue = innerQueue;
        }
        return ret;
    }
}
