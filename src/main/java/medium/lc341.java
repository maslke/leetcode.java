package medium;

import java.util.List;
import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/8/26
 * Version:0.0.1
 * 341. Flatten Nested List Iterator
 */
public class lc341 {

    class NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 0;
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }

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
            } else {
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
