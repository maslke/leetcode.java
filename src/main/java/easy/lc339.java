package easy;

import basic.NestedInteger;

import java.util.List;

// https://leetcode-cn.com/problems/nested-list-weight-sum/
// 339. 嵌套列表权重和

class lc339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger integer : list) {
            if (integer.isInteger()) {
                sum += depth * integer.getInteger();
            }
            else {
                sum += depthSum(integer.getList(), depth + 1);
            }
        }
        return sum;
    }
}