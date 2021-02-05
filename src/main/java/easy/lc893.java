package easy;

// https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/
// 893. 特殊等价字符串组

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc893 {
    public int numSpecialEquivGroups(String[] A) {
        int[][] val = new int[A.length][52];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                val[i][A[i].charAt(j) - 'a' + (j % 2) * 26]++;
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(Arrays.toString(val[i]));
        }
        return set.size();
    }
}
