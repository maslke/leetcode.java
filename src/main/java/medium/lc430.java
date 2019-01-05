//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
//430. Flatten a Multilevel Doubly Linked List
/*
// Definition for a Node.
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
};
*/
class Solution {
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

}