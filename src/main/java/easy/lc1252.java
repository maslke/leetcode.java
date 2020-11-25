package easy;

import java.util.HashSet;
import java.util.Set;

class lc1252 {
    public int oddCells(int n, int m ,int[][] indices) {
        int oddCounts = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int k = 0; k < indices.length; k++) {
                    if (indices[k][0] == i) {
                        sum += 1;
                    }
                    if (indices[k][1] == j) {
                        sum += 1;
                    }
                }
                oddCounts += sum % 2;
            }
        }
        return oddCounts;
    }

    public int oddCells2(int n, int m, int[][] indices) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < indices.length; i++) {
            if (set1.contains(indices[i][0])) {
                set1.remove(indices[i][0]);
            } else {
                set1.add(indices[i][0]);
            }

            if (set2.contains(indices[i][1])) {
                set2.remove(indices[i][1]);
            } else {
                set2.add(indices[i][1]);
            }
        }

        return m * set1.size() + n * set2.size() - 2 * set1.size() * set2.size();

    }
}

