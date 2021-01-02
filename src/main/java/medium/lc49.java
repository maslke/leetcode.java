package medium;

import java.util.*;

// https://leetcode-cn.com/problems/group-anagrams/
// 49. 字母异位词分组

public class lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            List<String> list = map.getOrDefault(temp, new ArrayList<>());
            list.add(str);
            map.put(temp, list);
        }

        return new ArrayList<>(map.values());
    }
}
