package easy;

import java.util.Arrays;

// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
// 1013. Partition Array into Three Parts With Equal Sum

class lc1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0) return false;
        int v = sum / 3;
        int i = 0;
        int j = A.length;
        int temp = 0;
        int count = 0;
        while (i < j) {
            temp += A[i];
            if (temp == v) {
                temp = 0;
                count++;
            } 
            i++;
        }
        return count == 3;
    }
}