package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author:maslke
 * Date:2017/9/11
 * Version:0.0.1
 * 565. Array Nesting
 */
public class lc565 {
    public int arrayNesting(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(i)) {
                if (max < map.get(i)) {
                    max = map.get(i);
                }
            } else {
                int len = 0;
                int inx = i;
                map2.put(inx, 1);
                while(inx <= nums.length - 1) {
                    if (map.containsKey(inx)) {
                        len = len + map.get(inx);
                        break;
                    } else {
                        len++;
                        inx = nums[inx];
                        if (map2.containsKey(inx)) {
                            break;
                        } else {
                            map2.put(inx, 1);
                        }
                    }
                }
                if (max < len) {
                    max = len;
                }
                map.put(i, len);
            }
        }
        return max;
    }
}

class lc565_2 {
    public int arrayNesting(int[] nums) {
        Set<Integer> set2 = new HashSet<>();
        int max = 0;
        int i = 0;
        while (i < nums.length) {
            if (set2.contains(i)) {
                i++;
                continue;
            }
            int first = nums[i];
            Set<Integer> set = new HashSet<>();
            int count = 0;
            set2.add(i);
            while (!set.contains(first)) {
                count++;
                set.add(first);
                if (first >= nums.length) break;
                first = nums[first];
                set2.add(first);
            }
            if (count > max) {
                max = count;
            }
            
        }
        return max;
    }
}
