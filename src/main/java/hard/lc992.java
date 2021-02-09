package hard;

// https://leetcode-cn.com/problems/subarrays-with-k-different-integers/
// 992. K个不同整数的子数组

public class lc992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return mostK(A, K) - mostK(A, K - 1);
    }

    private int mostK(int[] A, int k) {
        int left = 0;
        int right = 0;
        int len = A.length;

        int count = 0;
        int res = 0;
        int[] freq = new int[len + 1];
        while (right < len) {
            int v = A[right];
            if (freq[v] == 0) {
                count++;
            }

            freq[v]++;
            right++;

            while (count > k) {
                int v2 = A[left];
                freq[v2]--;

                if (freq[v2] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}
