package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/word-break/
// 139. 单词划分

class lc139 {
    Map<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        if (s.equals("")) return true;
        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                String s1 = s.substring(word.length(), s.length());
                boolean ret = wordBreak(s1, wordDict);
                map.put(s1, ret);
                if (ret) {
                    map.put(s, ret);
                    return true;
                } else {
                    map.put(s, false);
                }
            }
        }
        return false;
    }
}