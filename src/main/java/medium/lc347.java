package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/top-k-frequent-elements/
// 347. 前 K 个高频元素

class lc347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        int left = 0;
        int right = arr.length - 1;
        int num = arr.length - k;
        while (true) {
            int p = partition(arr, left, right, map);
            if (p == num) {
                int[] ret = new int[k];
                if (arr.length - p >= 0) System.arraycopy(arr, p, ret, 0, arr.length - p);
                return ret;
            } else if (p < num) {
                left = p + 1;
            } else {
                right = p - 1;
            }
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private int partition(int[] num, int left, int right, Map<Integer, Integer> map) {
        if (left == right) return left;
        int v = num[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (map.get(num[++i]) < map.get(v)) {
                if (i == right) break;
            }
            while (map.get(num[--j]) > map.get(v)) {
                if (j == left) break;
            }
            if (i >= j) break;
            swap(num, i, j);
        }
        swap(num, left, j);
        return j;
    }
}