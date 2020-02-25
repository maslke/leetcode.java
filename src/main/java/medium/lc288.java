package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode-cn.com/problems/unique-word-abbreviation/
// 288. 单词的唯一缩写 

class ValidWordAbbr {

    private Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        this.map = new HashMap<>();
        
        for (String d : dictionary) {
            String w = shorten(d);
            if (map.containsKey(w)) {
                map.get(w).add(d);
            } else {
                Set<String> list = new HashSet<>();
                list.add(d);
                map.put(w, list);
            }
        }
    }

    private String shorten(String w) {
        int length = w.length();
        if (length <= 2) return w;
        return w.substring(0, 1) + (length - 2) + w.substring(length - 1, length);
    }
    
    public boolean isUnique(String word) {
        String w = shorten(word);
        return !map.containsKey(w) || (map.get(w).size() == 1 && map.get(w).contains(word));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */