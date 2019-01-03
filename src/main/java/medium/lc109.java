/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 109. Convert Sorted List to Binary Search Tree
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode h = head;
        while (h != null) {
            count++;
            h = h.next;
        }
        h = head;
        ListNode[] data = new ListNode[count];
        for (int i = 0; i < count; i++) {
            data[i] = h;
            h = h.next;
        }
        return convert(data, 0, count - 1);
    }
    
    private TreeNode convert(ListNode[] nodes, int begin, int end) {
        if (begin > end) return null;
        int mid = (end - begin) / 2 + begin;
        TreeNode node = new TreeNode(nodes[mid].val);
        node.left = convert(nodes, begin, mid - 1);
        node.right = convert(nodes, mid + 1, end);
        return node;
    }
}