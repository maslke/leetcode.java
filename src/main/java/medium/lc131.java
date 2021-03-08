package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/palindrome-partitioning/
// 131. 分割回文串
// DO TWICE

public class lc131 {
    private int length;
    private List<List<String>> ret = new ArrayList<>();
    private List<String> answer = new ArrayList<>();

    private boolean[][] valid;
    public List<List<String>> partition(String s) {
        length = s.length();
        valid = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(valid[i], true);
        }
        // valid[i][j]  = valid[i + 1][j - 1] && (s.charAt(i) == s.charAt(j)
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                valid[i][j] = valid[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        dfs(s, 0);
        return ret;
    }

    private void dfs(String s, int index) {
        if (index == length) {
            ret.add(new ArrayList<>(answer));
            return;
        }

        for (int j = index; j < length; j++) {
            if (valid[index][j]) {
                answer.add(s.substring(index, j + 1));
                dfs(s, j + 1);
                answer.remove(answer.size() - 1);
            }
        }
    }
}
