# leetcode.java
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
1|[Two Sum](https://leetcode.com/problems/two-sum/)|Easy|yes|2018-12-28
2|[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|Medium|yes|2018-12-28
3|[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)|Medium|yes|
4|Median of Two Sorted Arrays|Hard|no|
6|[ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)|Medium|yes|2019-01-05
7|[Reverse Integer](https://leetcode.com/problems/reverse-integer/)|Easy|
80|[Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)|Medium|yes|2019-01-06
297|[Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)|Hard|yes|2019-01-05
430|[ Flatten a Multilevel Doubly Linked List](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/)|Medium|yes|2019-01-05
821|[Shortest Distance to a Character](https://leetcode.com/problems/shortest-distance-to-a-character/)|Easy|yes|2019-01-06



1. [Two Sum](https://leetcode.com/problems/two-sum/)

题目设定了一定会有符合要求的方案。
使用Map来记录序号，在遍及数组的时候，进行问题的求解。如果先遍历，存储到Map之后，再进行问题的求解，反而会加大问题的难度。

2. [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

链表的数据结构，使用两个指针同时向前移动，可以解决。需要注意的是，最后结果是否需要进位。

3. [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

6. [ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)

很简单的数组题目，可以使用List<List<String>>这种结果来存储遍历的结果。最后将结果顺序取出。
遍历的过程，可以分为竖直向下的部分和斜向上的部分。竖直向下的部分是从0 - n，斜向上的部分是从n - 1到1。

7. [Reverse Integer](https://leetcode.com/problems/reverse-integer/)

循环取最后一个数字，然后作为高位，继续处理下一个数字。
需要注意的是负数存储值的个数比正数多1。需要注意溢出的问题。
需要考虑原始数字是正数还是负数的情况。

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
