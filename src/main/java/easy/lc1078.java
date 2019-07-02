package easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// https://leetcode.com/problems/occurrences-after-bigram/
// 1078. Occurrences After Bigram

public class lc1078 {
    public String[] findOcurrences(String text, String first, String second) {
        Map<String, List<String>> map = new HashMap<>();
        String[] contents = text.split(" ");
        for (int i = 0; i < contents.length - 2; i++) {
            String key = contents[i] + contents[i + 1];
            if (map.containsKey(key)) {
                map.get(key).add(contents[i + 2]);
            } else {
                List<String> values = new ArrayList<>();
                values.add(contents[i + 2]);
                map.put(key, values);
            }
        }
        if (map.containsKey(first + second)) {
            return map.get(first + second).toArray(new String[0]);
        } else {
            return new String[0];
        }
    }
}