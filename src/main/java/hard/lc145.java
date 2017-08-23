package hard;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 145. Binary Tree Postorder Traversal
 */
public class lc145 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (map.containsKey(temp)) {
                ret.add(temp.val);
            } else {
                map.put(temp, 1);
                if (temp.left == null && temp.right == null) {
                    ret.add(temp.val);
                } else {
                    stack.push(temp);
                }

                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }
        }
        return ret;
    }
}
