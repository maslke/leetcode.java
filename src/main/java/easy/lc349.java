package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 349. Intersection of Two Arrays
 */
public class lc349 {

    public int[] intersections2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i]) && !set2.contains(nums2[i])) {
                result.add(nums2[i]);
                set2.add(nums2[i]);
            }
        }

        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        int[] ret;
        if (nums1.length == 0 || nums2.length == 0) {
            ret = new int[0];
            return ret;
        }
        List<Integer> items = new ArrayList<Integer>();
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map1.containsKey(nums1[i])) {
                map1.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!map2.containsKey(nums2[i])) {
                map2.put(nums2[i], 1);
            }
        }
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                items.add(key);
            }
        }
        ret = new int[items.size()];
        for (int i = 0; i < items.size(); i++) {
            ret[i] = items.get(i);
        }
        return ret;
    }
}
