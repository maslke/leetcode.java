package easy;

/**
 * Author:maslke
 * Date:2017/9/4
 * Version:0.0.1
 * 14. Longest Common Prefix
 */
public class lc14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        String target = "";
        for (int i = 0; i < strs.length; i++) {
            if (minLength > strs[i].length()) {
                minLength = strs[i].length();
                target = strs[i];
            }
        }
        for (int i = 0; i < minLength; i++) {
            char c = target.charAt(i);
            int j = 0;
            for (; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    break;
                }
            }
            if (j != strs.length) {
                return target.substring(0, i);
            }
        }
        return target;
    }


}
