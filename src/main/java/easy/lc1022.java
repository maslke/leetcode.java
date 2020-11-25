package easy;

import basic.TreeNode;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

class lc1022 {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        map.put(root, root.val);
        int result = 0;
         
        return result;
    }

    public int sumRootToLeafRe(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int val) {
        if (node == null) {
            return val;
        }
        if (node.left == null && node.right == null) {
            return val * 2 + node.val;
        }
        int value = 0;
        if (node.left != null) {
            value += sum(node.left, val * 2 + node.val);
        }
        if (node.right != null) {
            value += sum(node.right, val * 2 + node.val);
        }

        return value;
    }


}