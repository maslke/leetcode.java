package medium;

// https://leetcode-cn.com/problems/print-immutable-linked-list-in-reverse/
// 1265. 逆时针打印不可变链表

 // This is the ImmutableListNode's API interface.
 // You should not implement it, or speculate about its implementation.
 interface ImmutableListNode {
     public void printValue(); // print the value of this node.
     public ImmutableListNode getNext(); // return the next node.
 };

class lc1265 {
    public void printLinkedListInReverse(ImmutableListNode head) {
        print(head);  
    }

    private void print(ImmutableListNode node) {
        if (node == null) return;
        ImmutableListNode next = node.getNext();
            print(next);
            node.printValue();
    }
}