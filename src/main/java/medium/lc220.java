package medium;

import java.util.*;

// https://leetcode-cn.com/problems/contains-duplicate-iii/
// 220. 存在重复元素 III
public class lc220 {

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long key = set.ceiling((long) nums[i] - (long) t);
            if (key != null && key <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;


    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Long, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Long v = Long.parseLong(Integer.toString(nums[i]));
            List<Integer> list = map.getOrDefault(v, new ArrayList<>());
            list.add(i);
            map.put(v, list);
        }

        for (Map.Entry<Long, List<Integer>> entry : map.entrySet()) {
            Long key = entry.getKey();
            List<Integer> list = entry.getValue();

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 1) <= k) {
                    return true;
                }
            }

            Long key3 = key;
            while (true) {
                Long key2 = map.ceilingKey(key3 + 1);
                if (key2 != null) {
                    if (key2 - key > t) {
                        break;
                    }
                    List<Integer> list2 = map.get(key2);
                    int i = 0;
                    int j = 0;
                    while (i < list.size() && j < list2.size()) {
                        int v1 = list.get(i);
                        int v2 = list2.get(j);
                        if (Math.abs(v2 - v1) <= k) {
                            return true;
                        }
                        if (v1 > v2) {
                            j++;
                        } else {
                            i++;
                        }
                    }
                } else {
                    break;
                }
                key3++;
            }
        }

        return false;

    }
}
