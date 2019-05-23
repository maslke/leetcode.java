package easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

/**
 * Author:maslke Date:2017/8/30 Version:0.0.1 104. Maximum Depth of Binary Tree
 */
public class lc104 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, 1);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            int value = map.get(temp);
            if (temp.right != null) {
                stack.push(temp.right);
                map.put(temp.right, value + 1);
            }
            if (temp.left != null) {
                stack.push(temp.left);
                map.put(temp.left, value + 1);
            }
            if (temp.left == null && temp.right == null) {
                list.add(value);
            }
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
        return max;
    }
}
