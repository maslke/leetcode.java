package medium;

// https://leetcode-cn.com/problems/monotone-increasing-digits/
// 738. 单调递增的数字

public class lc738 {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < chars.length && chars[i] >= chars[i - 1]) {
            i++;
        }

        if (i < chars.length) {
            int j = 0;
            while (j < i - 1 && chars[j] != chars[i - 1]) {
                j++;
            }
            chars[j]--;
            for (int m = j + 1; m < chars.length; m++) {
                chars[m] = '9';
            }
        }

        return Integer.parseInt(new String(chars));
    }
}
