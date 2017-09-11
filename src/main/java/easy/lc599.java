package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/11
 * Version:0.0.1
 * 599. Minimum Index Sum of Two Lists
 */
public class lc599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        List<String> ret = new ArrayList<String>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int inx = i + map1.get(list2[i]);
                map2.put(list2[i], inx);
                if (min > inx) {
                    min = inx;
                }
            }
        }
        for (String key : map2.keySet()) {
            if (min == map2.get(key)) {
                ret.add(key);
            }
        }
        return ret.toArray(new String[ret.size()]);
    }
}
