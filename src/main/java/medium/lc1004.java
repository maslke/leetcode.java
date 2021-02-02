package medium;

// https://leetcode-cn.com/problems/max-consecutive-ones-iii/
// 1004. 最大连续1的个数 III
public class lc1004 {
    public int longestOnes(int[] A, int K) {
        int zero = 0;
        int one = 0;
        int max = 0;
        int left = 0;
        int right = 0;
        int len = A.length;
        while (right < len) {
            if (A[right] == 1) {
                one++;
            } else {
                zero++;
            }
            max = Math.max(max, one);
            if (zero > K) {
                if (A[left] == 1) {
                    one--;
                } else {
                    zero--;
                }
                left++;
            }
            right++;
        }

        return right - left;
    }
}
