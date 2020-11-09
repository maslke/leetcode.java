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
 * 199. Binary Tree Right Side View
 */
public class lc199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Queue<TreeNode> innerQueue = new LinkedList<TreeNode>();
            boolean flag = true;
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (flag) {
                    ret.add(temp.val);
                    flag = false;
                }
                if (temp.right != null) {
                    innerQueue.add(temp.right);
                }
                if (temp.left != null) {
                    innerQueue.add(temp.left);
                }
            }
            queue = innerQueue;
        }
        return ret;
    }
}
