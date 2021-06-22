package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
// 剑指 Offer 38. 字符串的排列
public class lc38 {

    private List<String> ret;
    private boolean[] visited;

    public String[] permutation(String s) {
        int n = s.length();
        ret = new ArrayList<>();
        visited = new boolean[n];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrace(chars, 0, new StringBuilder());
        return ret.toArray(new String[0]);
    }

    private void backtrace(char[] chars, int position, StringBuilder sb) {
        if (position == chars.length) {
            ret.add(sb.toString());
            return;
        }

        for (int j = 0; j < chars.length; j++) {
            if (visited[j] || (j > 0 && !visited[j] && chars[j] == chars[j - 1])) {
                continue;
            }
            visited[j] = true;
            sb.append(chars[j]);
            backtrace(chars, position + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[j] = false;
        }
    }
}
