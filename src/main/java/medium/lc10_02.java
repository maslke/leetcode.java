package medium;

// https://leetcode-cn.com/problems/group-anagrams-lcci/
// 面试题 10.02. 变位词组

import java.util.*;

public class lc10_02 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if (map.containsKey(temp)) {
                map.get(temp).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(temp, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
