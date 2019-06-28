//https://leetcode.com/problems/design-linked-list/
//707. Design Linked List

package easy;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
    
}

/**
 * it seems that leetcode adds new case.
 */
class MyLinkedList2 {

    private ListNode head;
    private int length;
    /** Initialize your data structure here. */
    public MyLinkedList2() {
        this.head = new ListNode(0);
        this.length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= this.length || index < 0) return -1;
        ListNode temp = this.head.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode next = this.head.next;
        ListNode node = new ListNode(val);
        this.head.next = node;
        node.next = next;
        this.length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode prev = this.head;
        ListNode temp = this.head.next;
        while (temp != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = new ListNode(val);
        this.length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > this.length) return;
        if (index <= 0) {
            this.addAtHead(val);
            return;
        }
        if (index == this.length) {
            this.addAtTail(val);
            return;
        }
        
        ListNode prev = this.head;
        ListNode temp = this.head.next;
        for (int i = 0; i < index; i++) {
            prev = temp;
            temp = temp.next;
        }
        ListNode node = new ListNode(val);
        prev.next = node;
        node.next = temp;
        this.length++;
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < this.length) {
            ListNode prev = this.head;
            ListNode temp = this.head.next;
            for (int i = 0; i < index; i++) {
                prev = temp;
                temp = temp.next;
            }
            if (temp != null) {
                prev.next = temp.next;
            }
            this.length--;
        }
    }
}

class MyLinkedList {
    
    private ListNode head;
    private ListNode tail;
    private int count;    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > count - 1 || index < 0) return -1;
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        count++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
       ListNode node = new ListNode(val);
       if (head == null) {
           head = node;
           tail = node;
       }  else {
           tail.next = node;
           tail = node;
       }
        count++;
    }
    
    private ListNode getAtIndex(int index) {
        if (index > count - 1 || index < 0) return null;
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > count || index < 0) return;
        if (index == count) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            ListNode prev = getAtIndex(index - 1);
            ListNode current = prev.next;
            ListNode node = new ListNode(val);
            prev.next = node;
            node.next = current;
            count++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > count - 1 || index < 0) return;
        if (index == 0) {
            head = head.next;
            count--;
        } else if (index == count - 1) {
            ListNode node = getAtIndex(count - 2);
            tail = node;
            node.next = null;
            count--;
        } else {
            ListNode node = getAtIndex(index - 1);
            node.next = node.next.next;
            count--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */