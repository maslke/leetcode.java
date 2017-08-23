package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class lc103 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        int inx = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            Queue<TreeNode> innerQueue = new LinkedList<TreeNode>();
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (inx % 2 == 1) {
                    level.add(0, temp.val);
                } else {
                    level.add(temp.val);
                }
                if (temp.left != null) {
                    innerQueue.add(temp.left);
                }
                if (temp.right != null) {
                    innerQueue.add(temp.right);
                }
            }
            inx++;
            ret.add(level);
            queue = innerQueue;
        }
        return ret;
    }
}
