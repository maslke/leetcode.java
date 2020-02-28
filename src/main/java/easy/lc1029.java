package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/two-city-scheduling/
// 1029. Two City Scheduling

class lc1029 {
    public int twoCitySchedCost(int[][] costs) {
        List<int[]> values = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            values.add(costs[i]);
        }
        
        Collections.sort(values, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
            }
        });
        int sum = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < costs.length; i++) {
            int[] v = values.get(i);
            if (a == values.size() / 2) {
                sum += v[1];
            } else if (b ==  values.size() / 2) {
                sum += v[0];
            } else {
                if (v[0] < v[1]) {
                    sum += v[0];
                    a++;
                } else {
                    sum += v[1];
                    b++;
                }
            }
        }
        return sum;
    }
}