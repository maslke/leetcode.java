package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/reconstruct-original-digits-from-english/
// 423. Reconstruct Original Digits from English

class Solution {
    public String originalDigits(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder[] sb = new StringBuilder[10];
        for (int i = 0; i < 10; i++) {
            sb[i] = new StringBuilder();
        }
        
        // 0
        if (map.containsKey('z') && map.get('z') > 0) {
            int count = map.get('z');
            for (int i = 0; i < count; i++) {
                sb[0].append("0");
            }
            map.remove('z');
            map.put('e', map.get('e') - count);
            map.put('r', map.get('r') - count);
            map.put('o', map.get('o') - count);
        }
        
        // 6
        if (map.containsKey('x') && map.get('x') > 0) {
            int count = map.get('x');
            for (int i = 0; i < count; i++) {
                sb[6].append("6");
            }
            map.remove('x');
            map.put('s', map.get('s') - count);
            map.put('i', map.get('i') - count);
        }
        
        
        // 4
        if (map.containsKey('u') && map.get('u') > 0) {
            int count = map.get('u');
            for (int i = 0; i < count; i++) {
                sb[4].append('4');
            }
            map.remove('u');
            map.put('f', map.get('f') - count);
            map.put('o', map.get('o') - count);
            map.put('r', map.get('r') - count);
        }
        
        // 3
        if (map.containsKey('r') && map.get('r') > 0) {
            int count = map.get('r');
            for (int i = 0; i < count; i++) {
                sb[3].append('3');
            }
            map.remove('r');
            map.put('t', map.get('t') - count);
            map.put('h', map.get('h') - count);
            map.put('e', map.get('e') - count * 2);
        }
        
        
        if (map.containsKey('f') && map.get('f') > 0) {
            int count = map.get('f');
            for (int i = 0; i < count; i++) {
                sb[5].append('5');
            }
            map.remove('f');
            map.put('i', map.get('i') - count);
            map.put('v', map.get('v') - count);
            map.put('e', map.get('e') - count);
        }
        
        
        if (map.containsKey('v') && map.get('v') > 0) {
            int count = map.get('v');
            for (int i = 0; i < count; i++) {
                sb[7].append('7');
            }
            map.remove('v');
            map.put('s', map.get('s') - count);
            map.put('e', map.get('e') - count * 2);
            map.put('n', map.get('n') - count);
        }
        
        
        if (map.containsKey('h') && map.get('h') > 0) {
            int count = map.get('h');
            for (int i = 0; i < count; i++) {
                sb[8].append('8');
            }
            map.remove('h');
            map.put('e', map.get('e') - count);
            map.put('i', map.get('i') - count);
            map.put('g', map.get('g') - count);
            map.put('t', map.get('t') - count);
        }
        
        
        if (map.containsKey('i') && map.get('i') > 0) {
            int count = map.get('i');
            for (int i = 0; i < count; i++) {
                sb[9].append('9');
            }
            map.remove('i');
            map.put('n', map.get('n') - count * 2);
            map.put('e', map.get('e') - count);
        }
        
        
        if (map.containsKey('e') && map.get('e') > 0) {
            int count = map.get('e');
            for (int i = 0; i < count; i++) {
                sb[1].append('1');
            }
            map.remove('e');
            map.put('o', map.get('o') - count);
            map.put('n', map.get('n') - count);
        }
        
        
        if (map.containsKey('t') && map.get('t') > 0) {
            int count = map.get('t');
            for (int i = 0; i < count; i++) {
                sb[2].append('2');
            }
        }
        
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < sb.length; i++) {
            ret.append(sb[i].toString());
        }
        return ret.toString();
        
    }
}