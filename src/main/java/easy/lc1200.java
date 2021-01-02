package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/minimum-absolute-difference/
// 1200. 最小绝对差

class lc1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(arr);
        int min = arr[1] - arr[0];

        List<Integer> first = new ArrayList<>();
        first.add(arr[0]);
        first.add(arr[1]);
        ret.add(first);

        for (int i = 2; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < min) {
                ret.clear();
            }
            if (diff <= min) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                ret.add(list);
                min = diff;
            }
        }

        return ret;
    }
}