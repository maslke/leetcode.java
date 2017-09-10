package easy;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/9/10
 * Version:0.0.1
 * 501. Find Mode in Binary Search Tree
 */
public class lc501 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            int val = temp.val;
            int count = map.containsKey(val) ? map.get(val) + 1 : 1;
            map.put(val, count);
            if (count > max) {
                max = count;
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int count = list.size();
        int[] ret = new int[count];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
