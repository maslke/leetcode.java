package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode-cn.com/problems/shift-2d-grid/submissions/
// 1260. 二维网格迁移

class lc1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = m * n;
        LinkedList<List<Integer>> ret = new LinkedList<>();
        int move = k % count;
        int x = 0;
        LinkedList<Integer> list = new LinkedList<>();

        // count - move
        for (int inx = count - move; inx < count; inx++) {
            int a = inx / n;
            int b = inx % n;

            list.add(grid[a][b]);
            x++;
            if (x == n) {
                ret.add(list);
                x = 0;
                list = new LinkedList<>();
            }

        }

        for (int inx = 0; inx < count - move; inx++) {
            int a = inx / n;
            int b = inx % n;
            list.addLast(grid[a][b]);
            x++;
            if (x == n) {
                ret.add(list);
                list = new LinkedList<>();
                x = 0;
            }
        }
        return ret;

    }
}