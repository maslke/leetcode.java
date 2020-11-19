package easy;

// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
// 1385. Find the Distance Value Between Two Arrays

import java.util.Arrays;

class lc1385 {

    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        int length = arr2.length;
        for (int value : arr1) {
            int m = 0;
            while (m < length && arr2[m] < value) {
                m++;
            }
            if (m == length) {
                count += value - arr2[length - 1] > d ? 1 : 0;
                continue;
            }
            int n = length - 1;
            while (n >= 0 && arr2[n] > value) {
                n--;
            }
            if (n < 0) {
                count += arr2[0] - value > d ? 1 : 0;
                continue;
            }

            if (arr2[m] -value > d && value - arr2[n] > d) {
                count++;
            }
        }
        return count;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
                if (!lessThan(arr2, 0, arr2.length - 1, arr1[i], d)) {
                    count++;
                }
        }
        
        return count;
    }
    
    private boolean lessThan(int[] values, int left, int right, int current, int d) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = values[middle];
            if (Math.abs(value - current) <= d) return true;
            if (value - current > d) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        } 
        return false;
    }
}