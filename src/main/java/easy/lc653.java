package easy;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/8/22
 * Version:0.0.1
 * 653. Two Sum IV - Input is a BST
 */
public class lc653 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (map.containsKey(temp)) {
                ret.add(temp.val);
            } else {
                map.put(temp, 1);
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp);
                    stack.push(temp.left);
                }
                if (temp.left == null && temp.right == null) {
                    ret.add(temp.val);
                }
            }
        }
        int i = 0, j = ret.size() - 1;
        boolean success = false;
        while(i < j) {
            int val = k - ret.get(i);
            if (val > ret.get(j)) {
                i++;
            } else if (val < ret.get(j)) {
                j--;
            } else {
                success = true;
                break;
            }
        }
        return success;
    }
}


}
