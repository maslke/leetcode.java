# leetcode.java
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
1|[Two Sum](https://leetcode.com/problems/two-sum/)|Easy|yes|
2|[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|Medium|yes|
3|[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)|Medium|yes|
4|Median of Two Sorted Arrays|Hard|no|
80|[Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)|Medium|yes|2019-01-06
297|[Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)|Hard|yes|2019-01-05
430|[ Flatten a Multilevel Doubly Linked List](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/)|Medium|yes|2019-01-05
821|[Shortest Distance to a Character](https://leetcode.com/problems/shortest-distance-to-a-character/)|Easy|yes|2019-01-06





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
