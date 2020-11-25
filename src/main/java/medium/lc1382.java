package medium;

// https://leetcode.com/problems/balance-a-binary-search-tree/
// 1382. Balance a Binary Search Tree

import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class lc1382 {
    private List<TreeNode> list;
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        list = new ArrayList<>();
        visit(root);
        int left = 0;
        int right = list.size() - 1;
        
        return build(list, left, right);
    }
    
    private TreeNode build(List<TreeNode> list, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = list.get(mid);
        root.left = build(list, left, mid - 1);
        root.right = build(list, mid + 1, right);
        return root;
    }
    
    private void visit(TreeNode node) {
        if (node == null) return;
        visit(node.left);
        list.add(node);
        visit(node.right);
    }
}