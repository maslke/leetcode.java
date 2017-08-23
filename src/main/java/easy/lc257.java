package easy;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 257. Binary Tree Paths
 */
public class lc257 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret  = new ArrayList<String>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List<Integer> ret1 = new ArrayList<Integer>();
        ret1.add(root.val);
        Map<TreeNode, List<Integer>> map = new HashMap<TreeNode, List<Integer>>();
        map.put(root, ret1);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left == null && temp.right == null) {
                List<Integer> list = map.get(temp);
                String msg = "";
                for (int i = 0; i < list.size(); i++) {
                    msg += "->" + list.get(i);
                }
                ret.add(msg.substring(2));
            }
            if (temp.right != null) {
                stack.push(temp.right);
                List<Integer> list1 = new ArrayList<Integer>(map.get(temp));
                list1.add(temp.right.val);
                map.put(temp.right, list1);
            }
            if (temp.left != null) {
                stack.push(temp.left);
                List<Integer> list2 = new ArrayList<Integer>(map.get(temp));
                list2.add(temp.left.val);
                map.put(temp.left, list2);
            }
        }
        return ret;
    }
}
