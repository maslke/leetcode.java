package easy;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
// 1337. The K Weakest Rows in a Matrix

class lc1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                count += mat[i][j];
            }
            if (map.containsKey(count)) {
                map.get(count).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(count, list);
            }
        }
        int[] ret = new int[k];
        int inx = 0;
        for (List<Integer> values : map.values()) {
            if (k <= values.size()) {
                for (int i = 0; i < k; i++) {
                    ret[inx++] = values.get(i);
                }
            } else {
                for (int i = 0; i < values.size(); i++) {
                    ret[inx++] = values.get(i);
                }
            }
            k = k - values.size();
        }
        return ret;
    }
}