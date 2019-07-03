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

    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) return -1;
        int index = s.length();
        for (char i = 'a'; i <= 'z'; i++) {
            if (s.indexOf(i) != -1 && s.indexOf(i) == s.lastIndexOf(i) && i < index) {
                index = i;
            }
        }
        return index == s.length() ? -1 : index;
    }

    public int firstUniqChar3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }


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
