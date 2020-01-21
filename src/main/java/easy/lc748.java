package easy;

import java.util.Map;
import java.util.HashMap;

class lc748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + 32);
            }
            if (c >= 'a' && c <= 'z') {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        int minLength = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (complete(new HashMap<>(map), word)) {
                if (minLength > word.length()) {
                    minLength = word.length();
                    index = i;
                }
            }
        }
        return words[index];
    }
    
    private boolean complete(Map<Character, Integer> map, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return map.isEmpty();
    }
}