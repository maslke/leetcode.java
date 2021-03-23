package medium;

import basic.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private int cursor;
    private List<NestedInteger> list;
    private NestedIterator iterator;
    private int val;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.cursor = 0;
        this.list = nestedList;
        this.iterator = null;
        this.val = 0;
    }

    @Override
    public Integer next() {
        return this.val;
    }

    @Override
    public boolean hasNext() {
        while (this.cursor < this.list.size()) {
            NestedInteger nestedInteger = this.list.get(this.cursor);
            if (nestedInteger.isInteger()) {
                this.val = nestedInteger.getInteger();
                this.cursor++;
                return true;
            } else {
                if (this.iterator == null) {
                    this.iterator = new NestedIterator(nestedInteger.getList());
                }
                if (this.iterator.hasNext()) {
                    this.val = this.iterator.next();
                    return true;
                }
            }
            this.iterator = null;
            this.cursor++;
        }
        return false;
    }
}
