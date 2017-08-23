package easy;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 113. Path Sum II
 */
public class lc113 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Map<TreeNode, List<Integer>> map2 = new HashMap<TreeNode, List<Integer>>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        stack.push(root);
        map.put(root, root.val);
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        map2.put(root, list);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left == null && temp.right == null) {
                if (map.get(temp) == sum) {
                    ret.add(map2.get(temp));
                }
            }
            if (temp.right != null) {
                stack.push(temp.right);
                map.put(temp.right, map.get(temp) + temp.right.val);
                list = map2.get(temp);
                List<Integer> list1 = new ArrayList<Integer>(list);
                list1.add(temp.right.val);
                map2.put(temp.right, list1);
            }
            if (temp.left != null) {
                stack.push(temp.left);
                map.put(temp.left, map.get(temp) + temp.left.val);
                list = map2.get(temp);
                List<Integer> list2 = new ArrayList<Integer>(list);
                list2.add(temp.left.val);
                map2.put(temp.left, list2);
            }
        }
        return ret;
    }
}
