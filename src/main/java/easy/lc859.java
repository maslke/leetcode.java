package easy;

//https://leetcode-cn.com/problems/buddy-strings/
// 859. 亲密字符串
class lc859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
        else {
            int len = s.length();
            int i = 0;
            while (i < len && s.charAt(i) == goal.charAt(i)) {
                i++;
            }
            if (i == len) {
                return false;
            }
            int j = len - 1;
            while (j > i && s.charAt(j) == goal.charAt(j)) {
                j--;
            }
            if (j == i) {
                return false;
            }

            if (s.charAt(i) != goal.charAt(j) || s.charAt(j) != goal.charAt(i)) {
                return false;
            }

            for (int m = i + 1; m < j; m++) {
                if (s.charAt(m) != goal.charAt(m)) {
                    return false;
                }
            }

        }
        return true;
    }
}