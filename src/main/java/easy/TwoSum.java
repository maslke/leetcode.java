package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/
// 170. 两数之和III —— 数据结构设计


class TwoSum {

    private List<Integer> values;
    private boolean sorted;

    /** Initialize your data structure here. */
    public TwoSum() {
        values = new ArrayList<>();
        sorted =false;
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        values.add(number);
        sorted = false;
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (!sorted) {
            Collections.sort(values);
            sorted = true;
        }
        int i = 0;
        int j = values.size() - 1;
        while (i < j) {
            int v = values.get(i) + values.get(j);
            if (v == value) return true;
            if (v > value) j--;
            else i++;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */