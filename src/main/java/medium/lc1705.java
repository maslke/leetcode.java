package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/
// 1705. 吃苹果的最大数目

public class lc1705 {
    public int eatenApples(int[] apples, int[] days) {
        int count = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < apples.length || !queue.isEmpty(); i++) {
            if (i < apples.length) {
                queue.offer(new int[]{i + days[i], apples[i]});
            }

            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                if (node[0] > i) {
                    count++;
                    if (node[1] > 1) {
                        node[1]--;
                        queue.offer(node);
                    }
                    break;
                }
            }
        }
        return count;

    }
}
