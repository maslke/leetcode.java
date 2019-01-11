//https://leetcode.com/problems/count-binary-substrings/
//
class Solution {
    public int countBinarySubstrings(String s) {
        int i = 0;
        int j = s.length();
        int count = 0;
        while (i < j) {
            char c = s.charAt(i);
            int m = i + 1;
            while (m < j) {
                if (s.charAt(m) == c) {
                    m++;
                } else {
                    break;
                }
            }
            if (m + m - i <= j) {
                String s1 = s.substring(i, m);
                String s2 = s.substring(m, m + m - i);
                int k = 0;
                while (k < s1.length()) {
                    if (s1.charAt(k) == s2.charAt(k)) {
                        break;
                    }
                    k++;
                }
                if (k == s1.length()) {
                    count++;
                }
            }
            i++;
        }
        return count;
    }
}