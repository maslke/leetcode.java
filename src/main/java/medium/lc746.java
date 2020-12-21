package medium;

// https://leetcode-cn.com/problems/min-cost-climbing-stairs/
// 746. 使用最小花费爬楼梯

public class lc746 {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0;
        int b = 0;
        int ret = 0;
        for (int i = 2; i <= cost.length; i++) {
            ret = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = ret;
        }
        return ret;

    }
}
