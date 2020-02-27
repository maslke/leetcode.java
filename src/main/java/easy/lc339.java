package easy;

import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

// https://leetcode-cn.com/problems/nested-list-weight-sum/
// 339. 嵌套列表权重和

class lc339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            NestedInteger integer = list.get(i);
            if (integer.isInteger()) {
                sum += depth * integer.getInteger();
            } else {
                sum += depthSum(integer.getList(), depth + 1);
            }
        }
        return sum;
    }
}