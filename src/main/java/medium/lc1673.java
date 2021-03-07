package medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode-cn.com/problems/find-the-most-competitive-subsequence/
// 1673. 找出最有竞争力的子序列

public class lc1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ret = new int[k];

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] > nums[i] && nums.length - i - 1 + queue.size() >= k) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        for (int i = 0; i < k; i++) {
            ret[i] = nums[queue.pollFirst()];
        }
        return ret;

    }
}
