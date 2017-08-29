package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:maslke
 * Date:2017/8/29
 * Version:0.0.1
 * 46. Permutations
 */
public class lc46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        ret.add(list);
        for (int i = 1; i < nums.length; i++) {
            ret = compose(ret, nums[i]);
        }
        return ret;
    }

    private List<List<Integer>> compose(List<List<Integer>> items, int inx) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int i = 0;
        for (List<Integer> list : items) {
            for (int j = 0; j <= list.size(); j++) {
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(j, inx);
                ret.add(newList);
            }
        }
        return ret;
    }
}
