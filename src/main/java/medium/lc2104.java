package medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode-cn.com/problems/sum-of-subarray-ranges/
// 2104. 子数组范围和
public class lc2104 {
    public long subArrayRanges(int[] nums) {
        long sum = 0;

        long[] min = count(nums, true);
        long[] max = count(nums, false);


        for (int i = 0; i < nums.length; i++) {
            sum += (max[i] - min[i]) * nums[i];
        }
        return sum;
    }

    private long[] count(int[] nums, boolean isMin) {
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && (isMin ? nums[deque.peekLast()] >= nums[i] : nums[deque.peekLast()] <= nums[i])) {
                deque.pollLast();
            }
            a[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.offerLast(i);
        }

        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && (isMin ? nums[deque.peekLast()] > nums[i] : nums[deque.peekLast()] < nums[i])) {
                deque.pollLast();
            }
            b[i] = deque.isEmpty() ? nums.length : deque.peekLast();
            deque.offerLast(i);
        }

        long[] ret = new long[n];
        for (int i = 0; i < n; i++) {
            ret[i] = (long) (b[i] - i) * (i - a[i]);
        }
        return ret;
    }
}
