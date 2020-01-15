package easy;

import java.util.Queue;
import java.util.Comparator;
import java.util.PriorityQueue;

class lc1046 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }

        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (queue.isEmpty()) {
                return a;
            }
            int b = queue.poll();
            queue.offer(a - b);
        }
        return -1;
    }
}