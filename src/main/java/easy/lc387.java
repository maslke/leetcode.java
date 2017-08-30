package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/8/29
 * Version:0.0.1
 * 387. First Unique Character in a String
 */
public class lc387 {
    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        int length = s.length();
        int ret = length;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> list = map.get(c);
                list.add(i);
                map.put(c, list);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(c, list);
            }
        }
        for (Character key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() == 1) {
                if (ret > list.get(0)) {
                    ret = list.get(0);
                }
            }
        }
        if (ret == length) {
            return -1;
        } else {
            return ret;
        }
    }
}
