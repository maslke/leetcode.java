package easy;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/8/29
 * Version:0.0.1
 */
public class lc530 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (map.containsKey(temp)) {
                values.add(temp.val);
            } else {
                map.put(temp, 1);
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                stack.push(temp);
                if(temp.left != null) {
                    stack.push(temp.left);
                }
            }
        }
        int min = 0;
        for (int i = 0; i < values.size(); i++) {
            if (i == 0) {
                min = Math.abs(values.get(i + 1) - values.get(i));
            } else if (i == values.size() - 1) {
                min = Math.min(Math.abs(values.get(i) - values.get(i - 1)), min);
            }
            else {
                min = Math.min(Math.min(Math.abs(values.get(i + 1) - values.get(i)), Math.abs(values.get(i) - values.get(i - 1))), min);
            }
        }
        return min;
    }
}
