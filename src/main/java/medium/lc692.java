package medium;

// https://leetcode.com/problems/top-k-frequent-words/
// 692. Top K Frequent Words

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class lc692 {
    class Node {
        String word;
        int count;

        Node(String w, int c) {
            this.word = w;
            this.count = c;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String w = words[i];
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if (b.count > a.count) {
                    return 1;
                } else if (b.count < a.count) {
                    return -1;
                } else {
                    return a.word.compareTo(b.word);
                }
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        List<String> result = new ArrayList<>();
        while (k > 0) {
            result.add(queue.poll().word);
        }

        return result;
    }
}