package medium;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-elements/
// 347. Top K Frequent Elements

class lc347 {
    class Node {
        int count;
        int value;

        Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int v = nums[i];
            if (map.containsKey(v)) {
                map.put(v, map.get(v) + 1);
            } else {
                map.put(v, 1);
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return b.count - a.count;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        List<Integer> result = new ArrayList<>();
        while (k > 0) {
            result.add(queue.poll().value);
            k--;
        }
        return result;

    }
}