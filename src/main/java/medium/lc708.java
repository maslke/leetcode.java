package medium;

// https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/
// 708. 循环有序列表的插入

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

}
class lc708 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        if (head.next == head) {
            Node node = new Node(insertVal);
            head.next = node;
            node.next = head;
            return head;
        }

        Node minNode = head;
        Node maxNode = head;
        int min = head.val;
        int max = head.val;
        Node temp = head.next;
        while (temp != head) {
            if (temp.val < min) {
                min = temp.val;
                minNode = temp;
            }
            if (temp.val >= max) {
                max = temp.val;
                maxNode = temp;
            }
            temp = temp.next;
        }

        if (insertVal <= min || insertVal >= max) {
            Node node = new Node(insertVal);
            node.next = minNode;
            maxNode.next = node;
            return head;
        } else {
            Node prev = minNode;
            temp = prev.next;
            while (temp != prev) {
                if (temp.val >= insertVal && prev.val <= insertVal) {
                    Node node = new Node(insertVal);
                    prev.next = node;
                    node.next = temp;
                    break;
                } 
                prev = temp;
                temp = temp.next;
            }
            return head;
        }    
    }
}