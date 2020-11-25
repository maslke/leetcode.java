package medium;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author:maslke
 * Date:2017/8/24
 * Version:0.0.1
 * 515. Find Largest Value in Each Tree Row
 */
public class lc515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            Queue<TreeNode> innerQueue = new LinkedList<TreeNode>();
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp.val > max) {
                    max = temp.val;
                }
                if (temp.left != null) {
                    innerQueue.add(temp.left);
                }
                if (temp.right != null) {
                    innerQueue.add(temp.right);
                }
            }
            ret.add(max);
            queue = innerQueue;
        }
        return ret;
    }
}
