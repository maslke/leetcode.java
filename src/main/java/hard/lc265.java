package hard;

// https://leetcode-cn.com/problems/paint-house-ii/
// 265. 粉刷房子II

class lc265 {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        
        for (int i = 1; i < costs.length; i++) {
            int inx = findMinIndex(costs[i - 1]);
            int inx2 = findMinIndex(costs[i - 1], inx);
            for (int j = 0; j < costs[i].length; j++) {
                if (inx == j) {
                    costs[i][j] += costs[i - 1][inx2];
                } else {
                    costs[i][j] += costs[i - 1][inx];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            if (min > costs[costs.length - 1][i]) {
                min = costs[costs.length - 1][i];
            }
        }
        return min;
       
        
    }

    private int findMinIndex(int[] values) {
        int inx = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (min > values[i]) {
                min = values[i];
                inx = i;
            }
        }
        return inx;
    }

    private int findMinIndex(int[] values, int index) {
        int inx = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (i == index) continue;
            if (min > values[i]) {
                min = values[i];
                inx = i;
            }
        }
        return inx;
    }
}

