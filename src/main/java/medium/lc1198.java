package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/find-smallest-common-element-in-all-rows/
// 1198. 找出所有行中最小公共元素

class lc1198 {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int v = mat[i][j];
                map.put(v, map.getOrDefault(v, 0) + 1);
            }
        }    
        int min = Integer.MAX_VALUE;
        boolean exist = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == mat.length) {
                exist = true;
                if (min > entry.getKey()) {

                    min = entry.getKey();
                }
            }
        }
        return exist ? min : -1;
    }
}