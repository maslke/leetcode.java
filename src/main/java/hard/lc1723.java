package hard;

// https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/
// 1723. 完成所有工作的最短时间
public class lc1723 {
    private int min = 0x3f3f3f3f;
    private int k;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] dp = new int[k];
        this.k = k;
        rec(jobs, 0, 0, dp, 0);
        return min;
    }

    private void rec(int[] jobs, int count, int i, int[] dp, int max) {
        if (max >= min) {
            return;
        }
        if (i == jobs.length) {
            min = max;
        } else {
            if (count < this.k) {
                dp[count] = jobs[i];
                rec(jobs, count + 1, i + 1, dp, Integer.max(max, dp[count]));
                dp[count] = 0;
            }

            for (int j = 0; j < count; j++) {
                dp[j] += jobs[i];
                rec(jobs, count, i + 1, dp, Integer.max(max, dp[j]));
                dp[j] -= jobs[i];
            }
        }
    }
}
