package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/time-based-key-value-store/
// 981. Time Based Key-Value Store
class TimeMap {

    static class Node {
        int timestamp;
        String value;

        Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Node>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Node> list = this.map.getOrDefault(key, new ArrayList<>());
        list.add(new Node(timestamp, value));
        this.map.put(key, list);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Node> list = this.map.get(key);
        if (list.isEmpty()) {
            return "";
        }

        if (timestamp < list.get(0).timestamp) {
            return "";
        }
        if (timestamp >= list.get(list.size() - 1).timestamp) {
            return list.get(list.size() - 1).value;
        }

        return binarysearch(list, timestamp);
    }

    private String binarysearch(List<Node> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int middle = (right - left) / 2 + left;
            Node node = list.get(middle);
            if (node.timestamp <= timestamp) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (left > 0) {
            return list.get(left - 1).value;
        }
        return "";
    }
}
