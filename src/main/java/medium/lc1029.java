package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/two-city-scheduling/
// 1029. 两地调度

public class lc1029 {
    public int twoCitySchedCost2(int[][] costs) {

        int sum = 0;
        // All to A
        for (int[] cost : costs) {
            sum += cost[0];
        }

        // select n to B
        // sum + priceB - priceA;
        Arrays.sort(costs, (a, b) -> {
            return (a[1] - a[0]) - (b[1] - b[0]);
        });

        for (int i = 0; i < costs.length / 2; i++) {
            sum += costs[i][1] - costs[i][0];
        }
        return sum;
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            int m = Math.abs(a[0] - a[1]);
            int n = Math.abs(b[0] - b[1]);
            return n - m;
        });

        int a = 0;
        int b = 0;
        int n = costs.length / 2;
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            if (a == n) {
                count += costs[i][1];
            } else if (b == n) {
                count += costs[i][0];
            } else {
                if (costs[i][0] > costs[i][1]) {
                    b++;
                    count += costs[i][1];
                } else {
                    a++;
                    count += costs[i][0];
                }
            }
        }
        return count;
    }
}
