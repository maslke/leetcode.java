package easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/roman-to-integer/
// 13. 罗马数字转整数
public class lc13 {
    public int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        int length = s.length();
        int i = length - 1;
        int ret = 0;
        while (i >= 0) {

            if (i > 1) {
                String temp = s.substring(i - 2, i + 1);
                if (map.containsKey(temp)) {
                    ret += map.get(temp);
                    i = i - 3;
                    continue;
                }
            }


            if (i > 0) {
                String temp = s.substring(i - 1, i + 1);
                if (map.containsKey(temp)) {
                    ret += map.get(temp);
                    i = i - 2;
                    continue;
                }
            }

            ret += map.get(s.substring(i, i + 1));
            i = i - 1;
        }

        return ret;
    }


    public int romanToInt2(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int ret = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (i < len - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ret -= map.get(s.charAt(i));
            } else {
                ret += map.get(s.charAt(i));
            }
        }
        return ret;
    }


}
