package easy;

import java.util.HashSet;
import java.util.Set;

class lc1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            if (set.contains(i)) continue;
            int v[] = dominoes[i];
            int c = 0;
            for (int j = i + 1; j < dominoes.length; j++) {
                if (set.contains(j)) continue;
                int[] v1 = dominoes[j];
                if ((v[0] == v1[0] && v[1] == v1[1]) || (v[0] == v1[1] && v[1] == v1[0])) {
                    c++;
                    set.add(j);
                }
            }
            if (c != 0) {
                count = count + getCount(c + 1);
            }
        }
        return count >= 2 ? count : 1;
    }
    
    private int getCount(int m) {
        int a = 1;
        for (int i = m  - 1; i <= m; i++) {
            a = a * i;
        }
        return a / 2;
    }
}