package easy;

import java.util.Map;
import java.util.HashMap;

class lc1160 {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int length = 0;
        for (String word : words) {
            if (compose(word, new HashMap<>(map))) {
                length += word.length();
            }
        }
        
        return length;
    }
    
    private boolean compose(String word, Map<Character, Integer> map) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            
        }
        
        return true;
    }
}