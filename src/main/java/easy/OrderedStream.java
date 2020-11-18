package easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/design-an-ordered-stream/
// 1656. 设计有序流

public class OrderedStream {

    private String[] values;
    private int ptr;

    public OrderedStream(int n) {
        this.values = new String[n];
        this.ptr = 0;
    }

    public List<String> insert(int id, String value) {
        this.values[id - 1] = value;
        List<String> ret = new ArrayList<>();
        while (this.ptr < this.values.length && this.values[this.ptr] != null) {
            ret.add(this.values[this.ptr]);
            this.ptr++;
        }
        return ret;
    }
}
