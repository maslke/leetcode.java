# leetcode.java
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
1|[Two Sum](https://leetcode.com/problems/two-sum/)|Easy|yes|2018-12-28
2|[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|Medium|yes|2018-12-28
3|[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)|Medium|yes|
4|Median of Two Sorted Arrays|Hard|no|
6|[ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)|Medium|yes|2019-01-05
7|[Reverse Integer](https://leetcode.com/problems/reverse-integer/)|Easy|
15|[3Sum](https://leetcode.com/problems/3sum/)|Medium|yes|2019-01-07
17|[Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)|Medium|yes|2017-01-04
19|[Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)|Medium|yes|2019-01-07
21|[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)|Easy|yes|2019-01-07
27|[Remove Element](https://leetcode.com/problems/remove-element/)|Easy|yes|2019-01-08
53|[Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)|Easy|yes|2019-01-07
55|[Jump Game](https://leetcode.com/problems/jump-game/)|Medium|yes|2019-01-07
58|[Length of Last Word](https://leetcode.com/problems/length-of-last-word/)|Easy|yes|2019-01-08
66|[Plus One](https://leetcode.com/problems/plus-one/)|Easy|yes|2019-01-07
80|[Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)|Medium|yes|2019-01-06
98|[Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)|Medium|yes|2019-01-07
102|[Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)|Medium|yes|2019-01-08
103|[Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)|Medium|yes|2019-01-08
222|[Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)|Medium|yes|2019-01-04
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


15. [3Sum](https://leetcode.com/problems/3sum/)

将数组进行排序之后，可以转换为3Sum来进行求解。

17. [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

广度优先遍历

19. [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

链表遍历的问题。可以采用一次遍历或是二次遍历。问题较为简单，不要将所有节点都存储到临时数组中。

21. [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

双指针遍历即可。

27. [Remove Element](https://leetcode.com/problems/remove-element/)

在移动数组元素的时候，即时的记录动态的数组长度即可。

53. [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

最大连续子序列和，经典问题。

55. [Jump Game](https://leetcode.com/problems/jump-game/)

动态规划。Reach[i] = Math.max(Reach[i - 1], i + nums[i])。

58. [Length of Last Word](https://leetcode.com/problems/length-of-last-word/)

一次遍历即可。

98. [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)

二叉树的中序遍历，在遍历的时候，保存前一个节点的值。如果节点的值是递增的，则是合法的二叉树

102. [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

二叉树层次遍历。

103. [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

二叉树层次遍历。

222. [Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)

计算完全二叉树的节点个数。最容易想到的是暴力的方式，通过层次遍历来进行解决。不过会超时。
对于完全二叉树来说，根节点之下，如果左右子树的高度一样，则左子树一定是完全二叉树。若不一致，则右子树一定是完全二叉树。根据此性质，可以递归的进行解决。

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
