package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/submissions/
// 1209. 删除字符串中的所有相邻重复项II
public class lc1209 {

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] times = new int[s.length()];
        int i = 0;
        while (i < sb.length()) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                times[i] = 1;
                i++;
            } else {
                times[i] = times[i - 1] + 1;
                if (times[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k + 1;
                } else {
                    i++;
                }
            }
        }
        return sb.toString();
    }
}
