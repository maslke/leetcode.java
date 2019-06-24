# leetcode.java
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
3|[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)|Medium|yes|
4|Median of Two Sorted Arrays|Hard|no|
6|[ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)|Medium|yes|2019-01-05
7|[Reverse Integer](https://leetcode.com/problems/reverse-integer/)|Easy|
17|[Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)|Medium|yes|2019-01-04
27|[Remove Element](https://leetcode.com/problems/remove-element/)|Easy|yes|2019-01-08
61|[Rotate List](https://leetcode.com/problems/rotate-list/)|Meidum|yes|2019-01-09
66|[Plus One](https://leetcode.com/problems/plus-one/)|Easy|yes|2019-01-07
67|[Add Binary](https://leetcode.com/problems/add-binary/)|Easy|yes|2019-01-07
80|[Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)|Medium|yes|2019-01-06
509|[Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)|Easy|yes|2019-01-09
821|[Shortest Distance to a Character](https://leetcode.com/problems/shortest-distance-to-a-character/)|Easy|yes|2019-01-06

3. [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

6. [ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)

很简单的数组题目，可以使用List<List<String>>这种结果来存储遍历的结果。最后将结果顺序取出。
遍历的过程，可以分为竖直向下的部分和斜向上的部分。竖直向下的部分是从0 - n，斜向上的部分是从n - 1到1。

7. [Reverse Integer](https://leetcode.com/problems/reverse-integer/)

循环取最后一个数字，然后作为高位，继续处理下一个数字。
需要注意的是负数存储值的个数比正数多1。需要注意溢出的问题。
需要考虑原始数字是正数还是负数的情况。

17. [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

广度优先遍历

27. [Remove Element](https://leetcode.com/problems/remove-element/)

在移动数组元素的时候，即时的记录动态的数组长度即可。



67. [Add Binary](https://leetcode.com/problems/add-binary/)

一次遍历即可，注意最后是否有进位。

509. [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)

斐波那契数列计算。缓存前面的结果。限制了最大的数字N。如果N很大，则需要考虑整型溢出的问题。



