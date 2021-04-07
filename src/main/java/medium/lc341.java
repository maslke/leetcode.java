package medium;

import basic.NestedInteger;

import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/flatten-nested-list-iterator/
// 341. 扁平化嵌套列表迭代器

public class lc341 {

    private Stack<Integer> stack;

    public lc341(List<NestedInteger> nestedList) {
        stack = new Stack<Integer>();
        fill(nestedList);
    }

    private void fill(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            NestedInteger ni = nestedList.get(i);
            if (ni.isInteger()) {
                stack.push(ni.getInteger());
            }
            else {
                List<NestedInteger> list = ni.getList();
                fill(list);
            }
        }
    }

    public Integer next() {
        return stack.pop();
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
