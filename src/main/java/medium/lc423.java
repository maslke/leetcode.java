package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/reconstruct-original-digits-from-english/
// 423. Reconstruct Original Digits from English

class lc423 {
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String[] left = new String[]{"ero", "", "wo", "tree", "fou", "ive", "ix", "seen", "eiht", "nne"};
        int[] digits = new int[10];
        char[] chars = new char[]{'z', 'g', 'h', 't', 'r', 'f', 'v', 's', 'i'};
        int[] numbers = new int[]{0, 8, 3, 2, 4, 5, 7, 6, 9};
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c) && map.get(c) > 0) {
                digits[numbers[i]] = map.get(c);
                for (int j = 0; j < left[numbers[i]].length(); j++) {
                    char c1 = left[numbers[i]].charAt(j);
                    map.put(c1, map.get(c1) - digits[numbers[i]]);
                }
            }
        }
        if (map.containsKey('o')) {
            digits[1] = map.get('o');
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}