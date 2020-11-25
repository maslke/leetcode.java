package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class lc399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int inx = 0;
        for (List<String> e : equations) {
            if (!map.containsKey(e.get(0))) {
                map.put(e.get(0), inx++);
            }
            if (!map.containsKey(e.get(1))) {
                map.put(e.get(1), inx++);
            }
        }
        double[][] matrix = new double[inx][inx];
        int i = 0;
        for (List<String> e : equations) {
            int inx1 = map.get(e.get(0));
            int inx2 = map.get(e.get(1));
            matrix[inx1][inx2] = values[i];
            matrix[inx2][inx1] = 1.0 / values[i];
            i++;
        }

        double[] ret = new double[queries.size()];
        i = 0;
        for (List<String> query : queries) {
            String a = query.get(0);
            String b = query.get(1);
            if (!map.containsKey(a) || !map.containsKey(b)) {
                ret[i] = -1.0;
            }
            else {

                int inx1 = map.get(a);
                int inx2 = map.get(b);
                ret[i] = dfs(matrix, inx1, inx2, new HashSet<Integer>());
            }
            i++;
        }

        return ret;
    }


    private double dfs(double[][] matrix, int inx1, int inx2, Set<Integer> set) {
        if (inx1 == inx2) {
            return 1.0;
        }
        double[] values = matrix[inx1];
        set.add(inx1);
        for (int i = 0; i < values.length; i++) {
            if (matrix[inx1][i] == 0 || set.contains(i)) {
                continue;
            }
            double v = dfs(matrix, i, inx2, set);
            if (v != -1.0) {
                return matrix[inx1][i] * v;
            }
        }
        return -1.0;
    }

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
            }
            else {
                //dfs
//                int inx1 = map.get(a);
//                int inx2 = map.get(b);
//                if (inx1 == inx2) {
//                    ret[i] = 1.0;
//                } else {
//                    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
//                    ret[i] = dfs(matrix, inx1, inx2, inx, map2);
//                }
                ret[i] = value(matrix, a, b, map);
            }
        }
        return ret;
    }

    private double value(double[][] matrix, String first, String second, Map<String, Integer> map) {
        if (!map.containsKey(first) || !map.containsKey(second)) {
            return -1.0;
        }

        int inx1 = map.get(first);
        int inx2 = map.get(second);
        if (inx1 == inx2) {
            return 1.0;
        }
        else {
            Stack<Integer> stack = new Stack<>();
            stack.push(inx1);
            boolean[] stacked = new boolean[matrix.length];
            stacked[inx1] = true;
            double value = 1.0;
            boolean[][] visted = new boolean[matrix.length][matrix.length];
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (top == inx2) {
                    for (int i = 0; i < stack.size() - 1; i++) {
                        value = value * matrix[stack.get(i)][stack.get(i + 1)];
                    }
                    return value;
                }
                else {
                    boolean placed = false;
                    for (int i = 0; i < matrix[top].length; i++) {
                        if (matrix[top][i] != 0 && !stacked[i] && !visted[top][i]) {
                            stack.push(i);
                            visted[top][i] = true;
                            stacked[i] = true;
                            placed = true;
                            break;
                        }

                    }
                    if (!placed) {
                        stacked[stack.pop()] = false;
                        Arrays.fill(visted[top], false);
                    }
                }
            }
        }
        return -1.0;
    }


    private double dfs(double[][] matrix, int inx1, int inx2, int count, Map<Integer, Integer> map) {
        if (map.containsKey(inx1)) {
            return -1;
        }
        else {
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
