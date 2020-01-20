package medium;

import java.util.List;
import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();     
        traverse(root, list);
        int totalValue = 0;
        for (int i = 0; i < list.size(); i++) {
            totalValue += list.get(i).val;
        }
        for (int i = 0; i < list.size(); i++) {
            int m = list.get(i).val;
            list.get(i).val = totalValue;
            totalValue -= m;
        }
        return root;
    }
    
    private void traverse(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        traverse(node.left, list);
        list.add(node);
        traverse(node.right, list);
    }
}