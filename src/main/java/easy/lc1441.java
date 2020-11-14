package easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/build-an-array-with-stack-operations/
// 1441. 用栈操作构建数组

public class lc1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ret = new ArrayList<>();
        int inx = 1;
        int i = 0;
        while (i < target.length) {
            if (target[i] == inx) {
                ret.add("Push");
                inx++;
                i++;
            } else {
                ret.add("Push");
                ret.add("Pop");
                inx++;
            }
        }
        return ret;
    }

}
