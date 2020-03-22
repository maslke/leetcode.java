package medium;

// https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
// 945. 使数组唯一的最小增量

import java.util.Arrays;

class lc945 {
    public int minIncrementForUnique(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                count += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return count;
    }
}