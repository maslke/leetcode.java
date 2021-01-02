package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode-cn.com/problems/least-number-of-unique-integers-after-k-removals/
// 1481. 不同整数的最少数目
public class lc1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(map.values());
        int size = queue.size();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            k = k - v;
            if (k >= 0) {
                size--;
            } else {
                break;
            }
        }
        return size;
    }
}
