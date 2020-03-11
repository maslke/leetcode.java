package easy;

// https://leetcode-cn.com/problems/count-substrings-with-only-one-distinct-letter/
// 1180. 统计只含单一字母的字串

class lc1180 {
    public int countLetters(String S) {
        if (S == null || S.equals("")) return 0;
        char[] chars = S.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        int count = 0;
        while (i <= j) {
            int m = i + 1;
            while (m <= j) {
                if (chars[m] != chars[i]) {
                    break;
                }
                m++;
            }
            int length = m - i;
            count += (1 + length) * length / 2;
            i = m;
        }
        return count;
    }
}