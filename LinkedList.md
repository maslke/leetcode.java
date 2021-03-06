# LinkedList(25/34)
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
2|[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|Medium|yes|2018-12-28
19|[Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)|Medium|yes|2019-01-07
21|[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)|Easy|yes|2019-01-07
23|[Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)|Hard|yes|2019-05-21
24|[Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)|Medimu|yes|2019-01-09
25|[Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)|Hard|yes|2019-05-21 
61|[Rotate List](https://leetcode.com/problems/rotate-list/)|Meidum|yes|2019-01-09
82|[Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)|Medium|yes|2019-01-09
83|[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)|Easy|yes|2019-01-09
86|[Partition List](https://leetcode.com/problems/partition-list/)|Medium|yes|2019-05-21
92|[Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)|Medium|yes|2019-01-11
109|[Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)|Medium|yes|2019-01-03
138|[Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)|Medium|yes|2019-01-11
141|[Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)|Easy|yes|2019-01-09
142|[Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)|Medium|yes|2019-05-21
143|[Reorder List](https://leetcode.com/problems/reorder-list/)|Medium|yes|2019-01-12
147|[Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/)|Medium|yes|2019-01-14
148|[Sort List](https://leetcode.com/problems/sort-list/)|Medium|yes|2019-01-18
160|[Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)|Easy|yes|2019-01-18
203|[Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)|Easy|yes|2019-01-23
206|[Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)|Easy|yes|2019-01-10
234|[Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)|Easy|yes|2019-01-10
237|[Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)|Easy|yes|2019-01-10
328|[Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/submissions/)|Medium|yes|2019-01-28
430|[Flatten a Multilevel Doubly Linked List](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/)|Medium|yes|2019-01-05
445|[Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)|Medium|yes|2019-01-10
707|[Design Linked List](https://leetcode.com/problems/design-linked-list/)|Easy|yes|2019-01-17
725|[Split Linked List in Parts](https://leetcode.com/problems/split-linked-list-in-parts/)|Medium|yes|2019-05-21
817|[Linked List Components](https://leetcode.com/problems/linked-list-components/)|Medium|yes|2019-01-23
876|[Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)|Easy|yes|2019-01-09
1019|[Next Greater Node in LinkedList](https://leetcode.com/problems/next-greater-node-in-linked-list/)|Medium|yes|2019-05-21

--------------------------------------------

2. [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

链表的数据结构，使用两个指针同时向前移动，可以解决。需要注意的是，最后结果是否需要进位。

19. [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

链表遍历的问题。可以采用一次遍历或是二次遍历。问题较为简单，不要将所有节点都存储到临时数组中。

21. [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

双指针遍历即可。

23. [Merge K Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)

最简单的思路，参考题目21. K个链表，先用第一个和第二个进行合并，然后再和第三个进行合并。

高级一些的思路是，1和2合并，3和4合并。。，完成第一次遍历后，然后再1和3合并，5和7合并。。使用归并的思路，每次遍历一遍之后，问题的规模变为原来的1/2。

24. [Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)

两个节点为一组，交换两个节点的位置。为了便于处理，可以设置一个哨兵节点。

25. [Reverse Nodes in K-Groups](https://leetcode.com/problems/reverse-nodes-in-k-group/)

k个节点为一组进行倒序，当不满足k个节点的时候，就不再继续处理。每组链表倒序完成后，需要和原来的链表组合起来。

61. [Rotate List](https://leetcode.com/problems/rotate-list/)

计算链表的长度，用k对len求余后，就是需要移动到链表头部的节点的个数.

82. [Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

一次遍历。在遍历的过程中，保存当前节点的前一个节点。

83. [Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

和82比较相似。可以递归的进行处理。从头节点开始，remove(head, head.next) => remove(head.next, head.next) | remove(head,head.next.next)

86. [Partition List](https://leetcode.com/problems/partition-list/)

遍历链表，遇到值比x大的节点，就拼接到链表的末尾，并从当前位置删除。

```java
public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode temp1  = h1;
        ListNode temp2 = h2;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            if (temp.val < x) {
                temp1.next = temp;
                temp.next = null;
                temp1 = temp;
            } else {
                temp2.next = temp;
                temp.next = null;
                temp2 = temp;
            }
            temp = next;
        }
        temp1.next = h2.next;
        return h1.next;      
    }
```

92. [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)

可以先计算出需要反转的节点的前一个节点和后一个节点。然后将中间的链表进行反转。最后连接起来即可。

109. [Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)

一个比较朴素的处理思路是将链表处理成数组。然后就转变成为排序后的数组生成二叉查找树的问题。不过这种题目的考核点明显不在这个地方。应该存在更好的办法。

查看资料，可以使用快慢指针法。慢指针一次移动一个位置，快指针一次移动两个位置。这样当筷子真到链表末尾的时候，慢指针指向中间位置。同事，还需要断开中间位置左右两个链表。

138. [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)

可以递归的进行解决。由于有random节点的存在，复制的时候，需要考虑此节点是否已经创建完成。

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

142. [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)

快慢指针。

143. [Reorder List](https://leetcode.com/problems/reorder-list/)

快慢指针法，取得后半段的链表，然后反转后半段的链表。

在反转之后，可以遍历后半段链表，依次插入即可。需要注意的从后半段的链表长度可能比长半段的长度大1.需要注意不要清空了可能存在的最后一个节点。

```java
public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        slow = reverse(slow);
        ListNode h = head;
        while (slow != null) {
            ListNode next = h.next;
            ListNode next2 = slow.next;
            h.next = slow;
            if (next == null) break;
            slow.next = next;
            h = next;
            slow = next2;
        }
        
    }
```    

147. [Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/)

插入排序。可以使用递归方法解决，也可以使用迭代方法解决。

```java
public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = head.next;
        head.next = null;
        // tail node
        ListNode prev2 = head;
        while (cur != null) {
            ListNode prev = h;
            ListNode current = h.next;
            while (current != null) {
                if (current.val <= cur.val) {
                    prev = current;
                    current = current.next;
                } else {
                    break;
                }
            }
            if (current == null) {
                prev.next = cur;
                prev2 = cur;
                cur = cur.next;
                prev2.next = null;
            } else {
                ListNode temp = cur.next;
                prev.next = cur;
                cur.next = current;
                cur = temp;
            }
            
        }
        return h.next;
    }
```

148. [Sort List](https://leetcode.com/problems/sort-list/)

可以使用147中的插入排序。

160. [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

计算链表的长度差，然后将长链表的指针提前向前移动长度差个距离。

203. [Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)

简单。相对而言，迭代的方式更加直接。

递归的写法如下

```java
 public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            remove(head, head.next, val);
            return head;
        }
    }
    
    private void remove(ListNode prev, ListNode current, int val) {
        if (current == null) return;
        if (current.val == val) {
            prev.next = current.next;
            remove(prev, current.next, val);
        } else {
            remove(current, current.next, val);
        }
    }
 ```   

206. [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

可以使用递归或者迭代来进行求解.

234. [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

首先去求链表的中间节点

然后将后半段链表反转

最后遍历去比较两个链表的节点。需要注意的是两个链表可能长度不一致，存在一个节点的长度差。在遍历比较节点值的时候，只需要比较存在的节点即可。

```java
public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode prev = null;
        // locate to the middle node
        ListNode slow = middle(head);
        ListNode fast = head;
        /// reverse the linkedlist
        slow = reverse(slow);
        while (fast != null || slow != null) {
            if (fast == null || slow == null) {
                return true;
            }
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
 ```   

237. [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)

遍历过程中，将下一个节点的值赋给前一个节点。同时修改尾指针。

328. [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/submissions/)

这个题目不错。值得反复思考一下。

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

707. [Design Linked List](https://leetcode.com/problems/design-linked-list/)

简单的题目，不过测试用例有些坑。

725. [](https://leetcode.com/problems/split-linked-list-in-parts/)


817. [Linked List Components](https://leetcode.com/problems/linked-list-components/)

可以使用Map来存储每个节点在链表中的序号。然后，即可根据节点的序号值来判断是否相连。

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

1019. [Next Greater Node in linkedList](https://leetcode.com/problems/next-greater-node-in-linked-list/)



