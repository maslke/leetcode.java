//https://leetcode.com/problems/binary-tree-paths/
//257. Binary Tree Paths
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
        List<String> ret = new ArrayList<>();
        if (root == null) return ret;
        Map<TreeNode, String> map = new HashMap<>();
        map.put(root, "" + root.val);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                ret.add(map.get(node));
                continue;    
            }
            
            if (node.right != null) {
                map.put(node.right, map.get(node) + "->" + node.right.val);
                stack.push(node.right);
            }
            if (node.left != null) {
                map.put(node.left, map.get(node) + "->" + node.left.val);
                stack.push(node.left);
            }
        }
        return ret;
    }
}
