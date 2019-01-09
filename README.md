# leetcode.java
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
1|[Two Sum](https://leetcode.com/problems/two-sum/)|Easy|yes|2018-12-28
3|[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)|Medium|yes|
4|Median of Two Sorted Arrays|Hard|no|
6|[ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)|Medium|yes|2019-01-05
7|[Reverse Integer](https://leetcode.com/problems/reverse-integer/)|Easy|
15|[3Sum](https://leetcode.com/problems/3sum/)|Medium|yes|2019-01-07
17|[Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)|Medium|yes|2019-01-04
27|[Remove Element](https://leetcode.com/problems/remove-element/)|Easy|yes|2019-01-08
53|[Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)|Easy|yes|2019-01-07
55|[Jump Game](https://leetcode.com/problems/jump-game/)|Medium|yes|2019-01-07
58|[Length of Last Word](https://leetcode.com/problems/length-of-last-word/)|Easy|yes|2019-01-08
61|[Rotate List](https://leetcode.com/problems/rotate-list/)|Meidum|yes|2019-01-09
62|[Unique Paths](https://leetcode.com/problems/unique-paths/)|Medium|yes|2019-01-08
64|[Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)|Medium|yes|2019-01-08
66|[Plus One](https://leetcode.com/problems/plus-one/)|Easy|yes|2019-01-07
67|[Add Binary](https://leetcode.com/problems/add-binary/)|Easy|yes|2019-01-07
80|[Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)|Medium|yes|2019-01-06
509|[Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)|Easy|yes|2019-01-09
746|[Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)|Easy|yes|2019-01-09
821|[Shortest Distance to a Character](https://leetcode.com/problems/shortest-distance-to-a-character/)|Easy|yes|2019-01-06
859|[Buddy Strings](https://leetcode.com/problems/buddy-strings/)|Easy|yes|2019-01-09

1. [Two Sum](https://leetcode.com/problems/two-sum/)

题目设定了一定会有符合要求的方案。
使用Map来记录序号，在遍及数组的时候，进行问题的求解。如果先遍历，存储到Map之后，再进行问题的求解，反而会加大问题的难度。

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

27. [Remove Element](https://leetcode.com/problems/remove-element/)

在移动数组元素的时候，即时的记录动态的数组长度即可。

53. [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

最大连续子序列和，经典问题。

55. [Jump Game](https://leetcode.com/problems/jump-game/)

动态规划。Reach[i] = Math.max(Reach[i - 1], i + nums[i])。

58. [Length of Last Word](https://leetcode.com/problems/length-of-last-word/)

一次遍历即可。

62. [Unique Paths](https://leetcode.com/problems/unique-paths/)

动态规划。和leetcode.64类似。 ret[i, j] = ret[i + 1, j] + ret[i, j + 1];

64. [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)

动态规划 ret[i, j] = grid[i, j] + Math.MIN(ret[i + 1, j], ret[i, j + 1])

67. [Add Binary](https://leetcode.com/problems/add-binary/)

一次遍历即可，注意最后是否有进位。

509. [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)

斐波那契数列计算。缓存前面的结果。限制了最大的数字N。如果N很大，则需要考虑整型溢出的问题。

746. [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

动态规划。ret[i] = Math.min(ret[i - 1] + cost[i - 1], ret[i - 2] + cost[i - 2]) 。其中ret[0] = ret[1] = 0;

859. [Buddy Strings](https://leetcode.com/problems/buddy-strings/)

判断两个字符串长度相等并且只有一个字符存在着交换。当两个字符串相等的时候，需要判断字符串中是否存在着重复的字符。即在字符串相等的时候，可以交换一个重复的字符。
