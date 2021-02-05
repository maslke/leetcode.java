package medium;

// https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
// 1208. 尽可能使字符串相等

public class lc1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int cost = 0;

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        while (right < len) {
            cost += res[right];
            if (cost > maxCost) {
                cost -= res[left];
                left++;
            }
            right++;
        }
        return right - left;
    }
}
