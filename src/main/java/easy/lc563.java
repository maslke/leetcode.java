package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/8/24
 * Version:0.0.1
 * 563. Binary Tree Tilt
 */
public class lc563 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public int findTilt(TreeNode root) {
        int ret = 0;
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            nodeList.add(temp);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        for (int i = 0; i < nodeList.size(); i++) {
            TreeNode temp = nodeList.get(i);
            int leftVal = findTotalValue(temp.left);
            int rightVal = findTotalValue(temp.right);
            ret += Math.abs(leftVal - rightVal);
        }
        return ret;
    }

    private int findTotalValue(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + findTotalValue(node.left) + findTotalValue(node.right);
    }
}
