package medium;

import java.util.List;

// https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
// 524. 通过删除字母匹配到字典里最长单词
public class lc524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String ret = "";
        for (String dict : dictionary) {
            if (valid(s, dict)) {
                if (ret.equals("")) {
                    ret = dict;
                }
                else {
                    if (ret.length() < dict.length() || (ret.length() == dict.length() && ret.compareTo(dict) > 0)) {
                        ret = dict;
                    }
                }
            }

        }
        return ret;
    }

    private boolean valid(String s, String dict) {
        int i = 0;
        int n = dict.length();
        int j = 0;
        while (i < n && j < s.length()) {
            if (dict.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return i == n;
    }
}
