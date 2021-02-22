package easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
// 438. 找到字符串中所有字母异位词

public class lc438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length())
            return result;
        char[] chars = new char[26];
        for (int i = 0; i < p.length(); i++) {
            chars[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;

        while (l < s.length()) {
            if (chars[s.charAt(r) - 'a'] > 0) {
                chars[s.charAt(r) - 'a']--;
                r++;
            } else {
                chars[s.charAt(l) - 'a']++;
                l++;
            }
            if (r - l == p.length())
                result.add(l);
        }
        return result;
    }
}
