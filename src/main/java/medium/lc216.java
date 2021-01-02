package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/combination-sum-iii/
// 216. 组合总数III

public class lc216 {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combine(0, k, n, new ArrayList<>());
        return ret;
    }

    private void combine(int begin, int count, int sum, List<Integer> combines) {
        if (count == 0 && sum == 0) {
            ret.add(new ArrayList<>(combines));
            return;
        }
        if (count - 1 < 0) {
            return;
        }
        for (int i = begin + 1; i <= 9; i++) {
            if (sum - i < 0) {
                continue;
            }
            combines.add(i);
            combine(i, count - 1, sum - i, combines);
            combines.remove(combines.size() - 1);
        }
    }
}
