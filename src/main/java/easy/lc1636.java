package easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/sort-array-by-increasing-frequency/

public class lc1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        sort(nums, map);
        return nums;

    }

    private void sort(int[] nums, Map<Integer, Integer> map) {
        sort(nums, 0, nums.length - 1, map);
    }

    private void sort(int[] nums, int left, int right, Map<Integer, Integer> map) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right, map);
        sort(nums, left, p - 1, map);
        sort(nums, p + 1, right, map);
    }

    private int partition(int[] nums, int left, int right, Map<Integer, Integer> map) {
        int m = nums[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (less(nums[++i], m, map)) {
                if (i >= right) {
                    break;
                }
            }
            while (less(m, nums[--j], map)) {
                if (j <= left) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private boolean less(int a, int b, Map<Integer, Integer> map) {
        int inx1 = map.get(a);
        int inx2 = map.get(b);
        if (inx1 == inx2) {
            return b < a;
        }
        else {
            return inx1 < inx2;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
