//https://leetcode.com/problems/min-cost-climbing-stairs/
//Min Cost Climbing Stairs
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len <= 2) return 0;
        int[] ret = new int[len];
        ret[0] = 0;
        ret[1] = 0;
        for (int i = 2; i < len; i++) {
            //one or two
            ret[i] = Math.min(ret[i - 1] + cost[i - 1], ret[i - 2] + cost[i - 2]);
        }
        return Math.min(ret[len - 1] + cost[len - 1], ret[len - 2] + cost[len - 2]);
    }
}