package medium;

// https://leetcode-cn.com/problems/palindrome-partitioning-ii/
// 132. 分割回文串II
// DO TWICE

import java.util.Arrays;

public class lc132 {
    public int minCut(String s) {
        int length = s.length();
        boolean[][] valid = new boolean[length][length];

        for (boolean[] v : valid) {
            Arrays.fill(v, true);
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                valid[i][j] = valid[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        int[] ret = new int[length];
        Arrays.fill(ret, length + 1);
        for (int i = 0; i < length; i++) {
            if (valid[0][i]) {
                ret[i] = 0;
            }
            else {
                for (int j = 0; j < i; j++) {
                    if (valid[j + 1][i]) {
                        ret[i] = Math.min(ret[i], ret[j] + 1);
                    }
                }
            }
        }

        return ret[length - 1];
    }
}
