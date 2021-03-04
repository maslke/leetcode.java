package hard;

// https://leetcode-cn.com/problems/russian-doll-envelopes/
// 354. 俄罗斯套娃问题

import java.util.Arrays;
import java.util.TreeSet;

public class lc354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        TreeSet<Integer> set = new TreeSet<>();
        for (int[] env : envelopes) {
            Integer val = set.ceiling(env[1]);
            if (val != null) {
                set.remove(val);
            }
            set.add(env[1]);
        }
        return set.size();
    }
}
