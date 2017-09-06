package medium;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/9/6
 * Version:0.0.1
 * 49. Group Anagrams
 */
public class lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return ret;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            if (map.containsKey(temp)) {
                List<String> list = map.get(temp);
                list.add(strs[i]);
                map.put(temp, list);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(temp, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
