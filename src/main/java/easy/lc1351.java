package easy;

// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
// 1351. Count Negative Numbers in a Sorted Matrix
class lc1351 {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int k = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= k; j--) {
                if (grid[i][j] < 0) {
                    count++;
                } else {
                    k = j;
                    break;
                }
            }
        }
        return count;
    }
}