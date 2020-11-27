package medium;

// https://leetcode-cn.com/problems/4sum-ii/
// 454. 四数相加 II

import java.util.HashMap;
import java.util.Map;

public class lc454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = A[i] + B[j];
                map1.put(sum, map1.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int i : C) {
            for (int j : D) {
                int sum = i + j;
                count += map1.getOrDefault(-1 * sum , 0);
            }
        }

        return count;
    }
}
