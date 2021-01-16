package easy;

// https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
// 1018. 可被5整除的二进制前缀

import java.util.ArrayList;
import java.util.List;

public class lc1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ret = new ArrayList<>();
        int prefix = 0;
        for (int i = 0; i < A.length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            ret.add(prefix == 0);
        }
        return ret;
    }
}
