package easy;

import java.util.*;

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
// 1337. The K Weakest Rows in a Matrix

class lc1337 {
    class Pair {
        int column;
        int row;

        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] values = mat[i];
            Pair p = new Pair(i, -1);
            search(values, 0, values.length - 1, p);
            list.add(p);
        }

        Collections.sort(list, (a, b) -> {
            if (a.column == b.column) {
                return a.row - b.row;
            }
            return a.column - b.column;
        });

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = list.get(i).row;
        }
        return ret;
    }

    private void search(int[] values, int left, int right, Pair p) {
        if (left > right) {
            return;
        }
        int middle = (right - left) / 2 + left;
        int value = values[middle];
        if (value == 1) {
            if (p.column == -1 || p.column < middle) {
                p.column = middle;
            }
            search(values, middle + 1, right, p);
        } else {
            search(values, left, middle - 1, p);
        }
    }
}