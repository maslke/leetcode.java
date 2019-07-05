package medium;

// https://leetcode.com/problems/sort-characters-by-frequency/
// 451. Sort Characters By Frequency

import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class lc451 {

    class Node {
        int count;
        char c;

        Node(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return b.count - a.count;
            }
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new Node(entry.getValue(), entry.getKey()));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < node.count; i++) {
                sb.append(String.valueOf(node.c));
            }
        }
        return sb.toString();
    }
}