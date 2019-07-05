package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 350. Intersection of Two Arrays II
 */
public class lc350 {

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] ret = new int[result.size()];
        for (int inx = 0; inx < result.size(); inx++) {
            ret[inx] = result.get(inx);
        }
        return ret;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] ret;
        if (nums1.length == 0 || nums2.length == 0) {
            ret = new int[0];
            return ret;
        }
        List<Integer> items = new ArrayList<Integer>();
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i])) {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            } else {
                map1.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])) {
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            } else {
                map2.put(nums2[i], 1);
            }
        }
        for (Integer key : map1.keySet()) {
            int loop1 = map1.get(key);
            if (map2.containsKey(key)) {
                int loop2 = map2.get(key);
                for (int i = 0; i < loop1 && i < loop2; i++) {
                    items.add(key);
                }
            }
        }
        ret = new int[items.size()];
        for (int i = 0; i < items.size(); i++) {
            ret[i] = items.get(i);
        }
        return ret;
    }
}
