package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 */
public class lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];
        Map<Integer, Integer> values = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            values.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int inx = values.get(nums1[i]);
            int j = inx + 1;
            for (;j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    ret[i] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length) {
                ret[i] = -1;
            }
        }
        return ret;
    }
}
