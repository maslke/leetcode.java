package medium;

import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

// https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
// 426. Convert Binary Search Tree To Doubly Linked List

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class lc426 {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node h = new Node(0);
        Node temp = h;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (set.contains(node)) {
                temp.right = node;
                node.left = temp;
                if (stack.isEmpty()) {
                    node.right = h.right;
                    h.right.left = node;
                } else {
                    temp = node;
                }
            } else {
                set.add(node);
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return h.right;  
    }
}