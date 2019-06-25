package medium;
//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
//430. Flatten a Multilevel Doubly Linked List

import java.util.List;
import java.util.ArrayList;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

class lc430 {
    public Node flatten(Node head) {
        if (head == null) return null;
        List<Node> nodes = new ArrayList<>();
        compose(head, nodes);
        nodes.get(0).child = null;
        for (int i = 1; i < nodes.size(); i++) {
            nodes.get(i - 1).next = nodes.get(i);
            nodes.get(i).prev = nodes.get(i - 1);
            nodes.get(i).child = null;
        }
        return nodes.get(0);
    }
    
    private void compose(Node head, List<Node> nodes) {
        if (head == null) {
            return;
        }
        nodes.add(head);
        if (head.child != null) {
            compose(head.child, nodes);
        }
        compose(head.next, nodes);
    }

    public Node flatten2(Node head) {
        flatten(null, head);
        return head;
    }


    private Node flatten2(Node prev, Node current) {
        if (current == null) return prev;
        Node child = current.child;
        Node next = current.next;
        if (prev != null) {
            prev.next = current;
            current.next = prev;
        }
        current.child = null;

        Node node = flatten2(current, child);
        return flatten2(node, next);
    }

    private Node flatten(Node prev, Node current) {
        if (current == null) return prev;
        Node next = current.next;
        Node child = current.child;
        if (prev != null) {
            prev.next = current;
        }
        current.prev = prev;
        if (child == null) {
            return flatten(current, current.next);
        } else {
            current.child = null;
            Node c = flatten(current, child);
            c.next = next;
            if (next != null) {
                next.prev = c;
            }
            return flatten(c, next);
        }
    }

}
