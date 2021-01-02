package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/prlems/bracket-lcci/
// 面试题 08.09. 括号
public class lc_0809 {
    private List<String> ret;

    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<>();
        dfs(n, n, "", 2 * n);
        return ret;
    }

    private void dfs(int left, int right, String str, int length) {
        if (str.length() == length) {
            ret.add(str);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, str + "(", length);
        }

        if (left < right) {
            dfs(left, right - 1, str + ")", length);
        }
    }
}
