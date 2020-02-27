package easy;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

// https://leetcode-cn.com/problems/high-five/
// 1086. 前五科的平均分

class lc1086 {
    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new TreeMap<>();
        Comparator<Integer> comparator =  new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };
        for (int i = 0; i < items.length; i++) {
            int[] v = items[i];
            Queue<Integer> queue = map.getOrDefault(v[0], new PriorityQueue<>(comparator));
            queue.add(v[1]);
            map.put(v[0], queue);
        }
        int[][] result = new int[map.size()][2];
        int inx = 0;
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            result[inx] = new int[2];
            result[inx][0] = entry.getKey();
            int count = Math.min(entry.getValue().size(), 5);
            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += entry.getValue().poll();
            }
            result[inx++][1] = sum / count;
        }
        return result;
    }
}