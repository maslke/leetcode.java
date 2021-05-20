package medium;

// https://leetcode-cn.com/problems/top-k-frequent-words/
// 692. 前K个高频单词

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class lc692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> {
            int f1 = map.get(a);
            int f2 = map.get(b);
            if (f1 == f2) {
                return a.compareTo(b);
            }
            return f2 - f1;
        });

        return list.subList(0, k);


    }
}