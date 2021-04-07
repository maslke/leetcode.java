package basic;

import java.util.List;

/**
 * NestedInteger
 */
public class NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.val = null;
        this.list = list;
    }

    public boolean isInteger() {
        return this.val != null && this.list == null;
    }

    public Integer getInteger() {
        return this.val;
    }

    public List<NestedInteger> getList() {
        return this.list;
    }
}
