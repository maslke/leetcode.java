package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/
// 1846. 减小和重新排列数组后的最大元素

public class lc1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[arr.length - 1];
    }

    public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
        int length = arr.length;
        int[] times = new int[length + 1];
        for (int n : arr) {
            times[Math.min(n, length)]++;
        }
        int miss = 0;
        for (int i = 1; i <= length; i++) {
            if (times[i] == 0) {
                miss++;
            } else {
                miss = miss - Math.min(times[i] - 1, miss);
            }
        }
        return length - miss;
    }
}
