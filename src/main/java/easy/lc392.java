package easy;

// https://leetcode-cn.com/problems/is-subsequence/
// 392. 判断子序列

class lc392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        String s1 = s.substring(0, 1);
        int index = t.indexOf(s1);
        if (index == -1) return false;
        return isSubsequence(s.substring(1), t.substring(index + 1));
    }

    public boolean isSubsequence2(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}