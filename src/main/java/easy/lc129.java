package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 129. Sum Root to Leaf Numbers
 */
public class lc129 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int i) {
            val = i;
        }
    }
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        map.put(root, root.val);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left == null && temp.right == null) {
                ret += map.get(temp);
            }
            if (temp.right != null) {
                stack.push(temp.right);
                map.put(temp.right, 10 * map.get(temp) + temp.right.val);
            }
            if (temp.left != null) {
                stack.push(temp.left);
                map.put(temp.left, 10 * map.get(temp) + temp.left.val);
            }
        }
        return ret;
    }
}
