package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/submissions/
// 1209. 删除字符串中的所有相邻重复项II
public class lc1209 {

    public String removeDuplicates2(String s, int k) {
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

    Map<Character, String> map = null;

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = s.length();
        if (map == null) {
            map = new HashMap<>();
            for (int inx = 0; inx < j; inx++) {
                char c = s.charAt(inx);
                if (!map.containsKey(c)) {
                    map.put(c, String.valueOf(c).repeat(Math.max(0, k)));
                }
            }
        }
        while (i < j) {
            char c = s.charAt(i);
            if (i + k - 1 < j) {
                if (s.substring(i, i + k).equals(map.get(c))) {
                    i = i + k;
                } else {
                    sb.append(c);
                    i = i + 1;
                }

            } else {
                sb.append(s, i, j);
                break;
            }
        }
        if (sb.length() == j) {
            return sb.toString();
        }
        return removeDuplicates(sb.toString(), k);
    }
}
