//https://leetcode.com/problems/maximum-width-of-binary-tree/
//662. Maximum Width of Binary Tree
package medium;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Definition for a binary tree node.
 * 
 **/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
 

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int width = 0;
        int begin = -1;
        int end = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    begin = map.get(node);
                }
                if (i == size - 1) {
                    end = map.get(node);
                }
                if (node.left != null) {
                    map.put(node.left, map.get(node) * 2 + 1);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, map.get(node) * 2 + 2);
                    queue.add(node.right);
                }
            }
            if (width < end - begin) {
                width = end - begin;
            }
            begin = -1;
            end = -1;
        }
        return width + 1;
    }
}