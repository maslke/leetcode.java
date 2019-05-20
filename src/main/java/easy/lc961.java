package easy;
import java.util.Map;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 * 961. N-Repeated Element in Size 2N Array
 */
class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                return A[i];
            } else {
                map.put(A[i], 1);
            }
        }
        return 0;
    }
}