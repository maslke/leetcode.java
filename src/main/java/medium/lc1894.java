package medium;

// https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
// 1894. 找到需要补充粉笔的学生编号
public class lc1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
//        long[] acc = new long[n];
//        acc[0] = chalk[0];
        long acc = 0;
        for (int j : chalk) {
            acc += j;
        }
        long s = k % acc;

        for (int i = 0; i < n; i++) {
            if (chalk[i] > s) {
                return i;
            }
            s = s - chalk[i];
        }
        return -1;
    }

    private int search(long[] acc, long s) {
        int ret = 0;
        int left = 0;
        int right = acc.length - 1;
        while (left <= right) {
            int m = (right - left) / 2 + left;
            long v = acc[m];
            if (v <= s) {
                left = m + 1;
            }
            else {
                ret = m;
                right = m - 1;
            }
        }

        return ret;
    }
}
