package easy;

import java.util.Arrays;

// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
// 1013. Partition Array into Three Parts With Equal Sum

class lc1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int m = 0; m < A.length; m++) {
            sum += A[m];
        }
        if (sum % 3 != 0) return false;
        int v = sum / 3;
        int i = 0;
        int j = A.length - 1;
        int sum1 = 0;
        while (i <= j) {
            sum1 += A[i];
            if (sum1 == v) {
                break;
            }
            i++;
        }
        if (i == j || j == i + 1) return false;   
        sum1 = 0;
        while (j > i) {
            sum1 += A[j];
            if (sum1 == v) break;
            j--;
        }
        if (j == i || j == i + 1) return false;

        sum1 = 0;
        for (int m = i + 1; m <= j - 1; m++) {
            sum1 += A[m];
        }
        if (sum1 == v) return true;
        return false;
    }
}