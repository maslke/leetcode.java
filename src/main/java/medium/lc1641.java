package medium;

// https://leetcode-cn.com/problems/count-sorted-vowel-strings/
// 1641. 统计字典序元音字符串的数目
public class lc1641 {
    private int ret;

    public int countVowelStrings(int n) {
        ret = 0;
        backtrace(n, 0, 0);
        return ret;
    }

    private void backtrace(int n, int position, int inx) {
        if (position == n) {
            ret++;
            return;
        }

        for (int i = inx; i < 5; i++) {
            backtrace(n, position + 1, i);
        }
    }
}
