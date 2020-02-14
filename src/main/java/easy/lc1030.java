package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/matrix-cells-in-distance-order/
// 1030. Matrix Cells in Distance Order

class lc1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, List<List<Integer>>> map = new TreeMap<Integer, List<List<Integer>>>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = distance(i, j, r0, c0);
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                if (map.containsKey(d)) {
                    map.get(d).add(list);
                } else {
                    List<List<Integer>> list1 = new ArrayList<List<Integer>>();
                    list1.add(list);
                    map.put(d, list1);
                }
            }
        }
        int[][] ret = new int[R * C][2];
        int m = 0;
        for (List<List<Integer>> values : map.values()) {
            for (List<Integer> value : values) {
                ret[m] = new int[2];
                ret[m][0] = value.get(0);
                ret[m][1] = value.get(1);
                m++;
            }
        }
        return ret;
        
    }
    
    private int distance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}

