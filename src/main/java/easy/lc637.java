package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 637. Average of Levels in Binary Tree
 */
public class lc637 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<Double>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = 0;
            List<Integer> level = new ArrayList<Integer>();
            Queue<TreeNode> innerQueue = new LinkedList<TreeNode>();
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                n++;
                if (temp.left != null) {
                    innerQueue.add(temp.left);
                }
                if (temp.right != null) {
                    innerQueue.add(temp.right);
                }
            }
            double sum = 0;
            for (Integer aLevel : level) {
                sum += aLevel * 1.0 / n;
            }
            ret.add(sum);
            queue = innerQueue;
        }
        return ret;
    }
}
