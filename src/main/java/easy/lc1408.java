package easy;

// https://leetcode-cn.com/problems/string-matching-in-an-array/
// 1408. 数组中的字符串匹配

import java.util.ArrayList;
import java.util.List;

public class lc1408 {
    public List<String> stringMatching(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(".").append(word);
        }
        List<String> res = new ArrayList<>();
        String all = sb.toString();
        for (String word : words) {
            if (sb.indexOf(word) != sb.lastIndexOf(word)) {
                res.add(word);
            }
        }
        return res;
    }
}
