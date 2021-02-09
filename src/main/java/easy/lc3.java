package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/submissions/
// 3. 无重复字符的最长子串

public class lc3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        int len = s.length();
        int res = 0;
        while (right < len) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                res = Math.max(res, right - left);
                int inx = map.get(c);
                for (int i = left; i <= inx; i++) {
                    map.remove(s.charAt(i));
                }
                left = inx + 1;
            } else {
                map.put(c, right);
                right++;
            }
        }
        return Math.max(res, right - left);
    }

    public int lengthOfLongestSubstring3(String s) {
        int length = s.length();
        int i = 0;
        int j = 0;
        int ret = 0;
        Set<Character> set = new HashSet<>();
        while (i < length && j < length) {
            char c = s.charAt(j);
            if (set.contains(c)) {
                set.remove(s.charAt(i++));
            } else {
                set.add(c);
                j++;
                ret = Math.max(ret, j - i);
            }
        }
        return ret;
    }


}
