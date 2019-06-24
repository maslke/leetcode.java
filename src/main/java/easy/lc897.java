package easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

/**
 * Author:maslke
 * Date:2018/12/27 
 * Version:0.0.1 
 * 897. Increasing Order Search Tree
 */
public class lc897 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return root;
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (set.contains(node)) {
                nodeList.add(node);
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                set.add(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).left = null;
            nodeList.get(i).right = nodeList.get(i + 1);
        }
        nodeList.get(nodeList.size() - 1).left = null;
        nodeList.get(nodeList.size() - 1).right = null;
        
        return nodeList.get(0);
    }
}
