package medium;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/8/22
 * Version:0.0.1
 * 94. Binary Tree Inorder Traversal
 */
public class lc94 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> ret = new ArrayList<Integer>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (map.containsKey(temp)) {
                ret.add(temp.val);
            } else {
                map.put(temp, 1);
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left == null) {
                    ret.add(temp.val);
                }
                if (temp.left != null) {
                    stack.push(temp);
                    stack.push(temp.left);
                }
            }

        }
        return ret;
    }
}
