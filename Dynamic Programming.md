# leetcode.java
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
55|[Jump Game](https://leetcode.com/problems/jump-game/)|Medium|yes|2019-01-07
62|[Unique Paths](https://leetcode.com/problems/unique-paths/)|Medium|yes|2019-01-08
64|[Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)|Medium|yes|2019-01-08
494|[Target Sum](https://leetcode.com/problems/target-sum/)|Medium|yes|2010-01-12
746|[Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)|Easy|yes|2019-01-09

55. [Jump Game](https://leetcode.com/problems/jump-game/)

动态规划。Reach[i] = Math.max(Reach[i - 1], i + nums[i])。

62. [Unique Paths](https://leetcode.com/problems/unique-paths/)

动态规划。和leetcode.64类似。 ret[i, j] = ret[i + 1, j] + ret[i, j + 1];

64. [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)

动态规划 ret[i, j] = grid[i, j] + Math.MIN(ret[i + 1, j], ret[i, j + 1])

494. [Target Sum](https://leetcode.com/problems/target-sum/)

可以使用递归来进行解决。ret(begin, end, sum) = ret(begin + 1, end, sum + nums[begin]) + ret(begin + 1, end, sum - nums[begin])

在begin和end相等的时候，可以进行求解。 当nums[begin] == Math.abs(sum)的时候，有解存在。

需要注意的是，在sum为0的时候，此时解的个数为2

746. [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

动态规划。ret[i] = Math.min(ret[i - 1] + cost[i - 1], ret[i - 2] + cost[i - 2]) 。其中ret[0] = ret[1] = 0;
