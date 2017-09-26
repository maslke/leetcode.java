package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/26
 * Version:0.0.1
 * 290. Word Pattern
 */
public class lc290 {
    public boolean wordPattern(String pattern, String str) {
        String[] parts = str.split(" ");
        if (parts.length != pattern.length()) {
            return false;
        }
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> map2 = new HashMap<String, String>();
        for (int i = 0; i < parts.length; i++) {
            String s = pattern.substring(i, i + 1);
            if (map.containsKey(s)) {
                if (!map.get(s).equals(parts[i])) {
                    return false;
                }
            } else {
                map.put(s, parts[i]);
                if (map2.containsKey(parts[i]) && !map2.get(parts[i]).equals(s)) {
                    return false;
                }
                map2.put(parts[i], s);
            }
        }
        return true;
    }
}
