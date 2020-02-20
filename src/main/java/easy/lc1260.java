package easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/shift-2d-grid/
//  1260. Shift 2D Grid
class lc1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        List<Integer> list = new ArrayList<>();
        int count = k;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (count > 0) {
                    list.add(0, grid[i][j]);
                    count--;
                } else {
                    break;
                }
            }
        }
        count = m * n - k;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count > 0) {
                    list.add(grid[i][j]);
                    count--;
                } else {
                    break;
                }
            }
        }
        count = 0;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            count++;
            level.add(list.get(i));
            if (count % n == 0) {
                ret.add(level);
                level = new ArrayList<>();
            }
        }
        return ret;
    }
}