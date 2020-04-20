package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/17
 * Version:0.0.1
 * 399. Evaluate Division
 */
public class lc399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int len = equations.length;
        int inx = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                if (!map.containsKey(equations[i][j])) {
                    map.put(equations[i][j], inx++);
                }
            }
        }
        double[][] matrix = new double[inx][inx];
        for (int i = 0; i < len; i++) {
            int inx1 = map.get(equations[i][0]);
            int inx2 = map.get(equations[i][1]);
            double v = values[i];
            matrix[inx1][inx2] = v;
            matrix[inx2][inx1] = 1 / v;
        }
        double[] ret = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0];
            String b = queries[i][1];
            if (!map.containsKey(a) || !map.containsKey(b)) {
                ret[i] = -1.0;
            } else {
                //dfs
                int inx1 = map.get(a);
                int inx2 = map.get(b);
                if (inx1 == inx2) {
                    ret[i] = 1.0;
                } else {
                    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
                    ret[i] = dfs(matrix, inx1, inx2, inx, map2);
                }
            }
        }
        return ret;
    }

    private double dfs(double[][] matrix, int inx1, int inx2, int count, Map<Integer, Integer> map) {
        if (map.containsKey(inx1)) {
            return -1;
        } else {
            map.put(inx1, 1);
        }
        double value = -1.0;
        if (matrix[inx1][inx2] != 0) {
            return matrix[inx1][inx2];
        }
        if (inx1 == inx2) {
            return 1.0;
        }
        for (int i = 0; i < count; i++) {
            if (i == inx1 || matrix[inx1][i] == 0) {
                continue;
            }
            double v = dfs(matrix, i, inx2, count, map);
            if (v != -1) {
                value = v * matrix[inx1][i];
            }
        }

        return value;
    }
}
