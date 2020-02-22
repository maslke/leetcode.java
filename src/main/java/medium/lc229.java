package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/majority-element-ii/
//  229. Majority Element II

class lc229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length < 2) {
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            return list;
        }
        int a = nums[0];
        int b = nums[1];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v == a) {
                count1++;
                continue;
            }
            if (v == b) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                count1 = 1;
                a = v;
                continue;
            }
            if (count2 == 0) {
                count2 = 1;
                b = v;
                continue;
            }
            
            count1--;
            count2--;
        }
        
        int length = nums.length / 3;
        int len1 = 0;
        int len2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                len1++;
            }
            if (nums[i] == b) {
                len2++;
            }
        }
        
        if (len1 > length) {
            list.add(a);
        }
        if (len2 > length && a != b) {
            list.add(b);
        }
        
        return list;
    }
}