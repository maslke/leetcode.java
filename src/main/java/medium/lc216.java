package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/combination-sum-iii/
// 216. 组合总数III

public class lc216 {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        for (int i = 1; i <= 9; i++) {
            List<Integer> combines = new ArrayList<>();
            combines.add(i);
            combine(i + 1, k - 1, n - i, combines);
        }
        return ret;


    }

    private void combine(int begin, int count, int sum, List<Integer> combines) {
        if (count == 0 && sum == 0) {
            ret.add(new ArrayList<>(combines));
            return;
        }
        if (count <= 0 || sum <= 0) {
            return;
        }
        for (int i = begin; i <= 9; i++) {
            combines.add(i);
            combine(i + 1, count - 1, sum - i, combines);
            combines.remove(combines.size() - 1);
        }
    }
}
