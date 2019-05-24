package easy;
import java.util.Map;
import java.util.HashMap;

/**
 * Author:maslke
 * Date:2017/9/2
 * Version:0.0.1
 * 3. Longest Substring Without Repeating Characters
 */
public class lc3 {

    public int lengthOfLongestSubstring2(String s) {
        int i = 0;
        int length = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (i < s.length() - 1) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                i = map.get(c) + 1;
                length = 0;
                map.clear();    
            } else {
                i++;
                length++;
                if (maxLength < length) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }



    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0, j = s.length() - 1;
        int max = 0;
        while (i <= j) {
            map.clear();
            int len = 0;
            int k = i;
            for (; k <= j; k++) {
                char c = s.charAt(k);
                if (map.containsKey(c)) {
                    break;
                } else {
                    map.put(c, 1);
                    len++;
                }
            }
            if (max < len) {
                max = len;
            }
            i++;
        }
        return max;
    }
}
