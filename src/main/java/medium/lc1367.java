package medium;

// https://leetcode.com/problems/linked-list-in-binary-tree/
// 1367. Linked List in Binary Tree

import basic.TreeNode;

class lc1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (root.val == head.val) {
            if (helper(head.next, root.left)) return true;
            if (helper(head.next, root.right)) return true;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean helper(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;
        return helper(head.next, root.left) || helper(head.next, root.right);
    }
}