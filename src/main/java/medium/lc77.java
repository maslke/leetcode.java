package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/submissions/
// 77. Combinations


class lc77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void combine(int begin, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(list);
            return;
        }
        for (int i = begin; i <= n; i++) {
            List<Integer> list2 = new ArrayList<>(list);
            list2.add(i);
            combine(i + 1, n, k, list2, result);
        }
    }
}