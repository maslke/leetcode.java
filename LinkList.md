# LinkList(12/34)
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
2|[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|Medium|yes|2018-12-28
19|[Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)|Medium|yes|2019-01-07
21|[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)|Easy|yes|2019-01-07
23|[Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)|Hard|no|
24|[Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)|Medimu|yes|2019-01-09
25|[Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)|Hard|no|
61|[Rotate List](https://leetcode.com/problems/rotate-list/)|Meidum|yes|2019-01-09
82|[Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)|Medium|yes|2019-01-09
83|[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)|Easy|yes|2019-01-09
86|[Partition List](https://leetcode.com/problems/partition-list/)|Medium|yes|
92|[Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)|Medium|yes|
109|[Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)|Medium|yes|2019-01-03
141|[Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)|Easy|yes|2019-01-09
142|[Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)|Medium|yes
206|[Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)|Easy|yes|2019-01-10
297|[Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)|Hard|yes|2019-01-05
430|[Flatten a Multilevel Doubly Linked List](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/)|Medium|yes|2019-01-05
445|[Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)|Medium|yes|2019-01-10
876|[Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)|Easy|yes|2019-01-09

2. [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

链表的数据结构，使用两个指针同时向前移动，可以解决。需要注意的是，最后结果是否需要进位。

19. [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

链表遍历的问题。可以采用一次遍历或是二次遍历。问题较为简单，不要将所有节点都存储到临时数组中。

21. [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

双指针遍历即可。

24. [Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)

两个节点为一组，交换两个节点的位置。为了便于处理，可以设置一个哨兵节点。

61. [Rotate List](https://leetcode.com/problems/rotate-list/)

82. [Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

一次遍历。在遍历的过程中，保存当前节点的前一个节点。

83. [Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

和82比较相似。可以递归的进行处理。从头节点开始，remove(head, head.next) => remove(head.next, head.next) | remove(head,head.next.next)

109. [Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)

一个比较朴素的处理思路是将链表处理成数组。然后就转变成为排序后的数组生成二叉查找树的问题。不过这种题目的考核点明显不在这个地方。应该存在更好的办法。

查看资料，可以使用快慢指针法。慢指针一次移动一个位置，快指针一次移动两个位置。这样当筷子真到链表末尾的时候，慢指针指向中间位置。同事，还需要断开中间位置左右两个链表。


141. [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

快慢指针法.

```java
public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast =head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
```

206. [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

可以使用递归或者迭代来进行求解.

430. [Flatten a Multilevel Doubly Linked List](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/)

节点有next指针、prev指针和child指针，要求将链表展开。在节点同时有next节点和child节点的时候，优先排列child，然后再排列next。
很容易想到使用递归的方式。最简单的方式是使用临时存储，在遍历链表的时候，不处理各个节点之间指针的指向关系，先将所有的节点存储到一个List中。
然后使用二次遍历，按照list中存储的顺序，来来处理指针的指向。需要注意的是需要将child指针置空。

不使用临时存储的话，同样使用递归的方式，在一次遍历的过程中，处理好指针引用。针对当前节点，如果节点child指针为空，可以处理下一个节点。如果节点的child不为空，则以child节点为当前节点，递归的执行。child节点处理完成后，处理next节点。
```java
class Solution {
    public Node flatten(Node head) {
        flatten(null, head);
        return head;
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
```

445. [Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)

反转链表之后进行求解.

876. [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)

快慢指针.快指针是慢指针的两倍速度。当快指针到末尾的时候，慢指针到中间位置。

```java
public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;   
    }
```    

