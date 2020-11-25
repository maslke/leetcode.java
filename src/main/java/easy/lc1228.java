package easy;

// https://leetcode-cn.com/problems/missing-number-in-arithmetic-progression/
// 1228. 等差数列中缺失的数字

class Solution {
    public int missingNumber(int[] arr) {
        int max = arr[arr.length - 1];
        int min = arr[0];
        int diff = (max - min) / arr.length;
        if (diff == 0) return min;
        boolean[] ret = new boolean[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            ret[(arr[i] - min) / diff] = true; 
        }
        for (int i = 0; i < arr.length + 1; i++) {
            if (!ret[i]) {
                return min + i * diff;
            }
        }
        return -1;
    }
}