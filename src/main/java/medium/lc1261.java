package medium;

import basic.TreeNode;

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    
    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                set.add(node.val);
                if (node.left != null) {
                    node.left.val = 2 * node.val + 1;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = 2 * node.val + 2;
                    queue.add(node.right);
                }
            }
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);    
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */