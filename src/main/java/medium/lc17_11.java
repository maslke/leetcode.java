package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/find-closest-lcci/
// 面试题 17.11. 单词距离

public class lc17_11 {
    Map<String, List<Integer>> map = new HashMap<>();

    public int findClosest(String[] words, String word1, String word2) {
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (map.containsKey(w)) {
                map.get(w).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(w, list);
            }
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            int a = list1.get(i);
            int b = list2.get(j);
            if (min > Math.abs(a - b)) {
                min = Math.abs(a - b);
                if (min == 0) {
                    return min;
                }
            }
            if (a > b) {
                j++;
            } else {
                i++;
            }

        }
        return min;
    }
}
