package easy;

// https://leetcode-cn.com/problems/paint-house/
// 256. 粉刷房子

class lc256 {
    public int minCost(int[][] costs) {
        int min = 0;
        if (costs.length == 1) {
             return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
            if (i == costs.length - 1) {
                min = Math.min(costs[i][0], Math.min(costs[i][1], costs[i][2]));
            }
        }

        return min;
    }
}