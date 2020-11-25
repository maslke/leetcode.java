package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/freedom-trail/
// 514. 自由之路

public class lc514 {
    public int findRotateSteps(String ring, String key) {

        int m = ring.length();
        int n = key.length();

        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        // ring中每个字符所在的位置
        for (int i = 0; i < m; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }

        // 对于key中的第i个字符，ring中的第j个字符需要移动的最小次数
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // pos[key.charAt(0) - 'a']中存储的为同样的字符在ring中的位置
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, m - i) + 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + 1 + Math.min(Math.abs(j - k), m - Math.abs(j - k)));
                }
            }
        }


        return Arrays.stream(dp[n - 1]).min().getAsInt();

    }
}
