package medium;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/8/22
 * Version:0.0.1
 * 98. Validate Binary Search Tree
 */
public class lc98 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int i) {
            val = i;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        List<Integer> ret = new ArrayList<Integer>();
        stack.push(root);
        while (!stack.isEmpty()) {
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
        for (int i = 0 ; i < ret.size(); i++) {
            if (i == ret.size() - 1) {
                return true;
            }
            if (ret.get(i) >= ret.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}