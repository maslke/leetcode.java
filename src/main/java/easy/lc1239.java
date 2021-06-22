package easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
// 1239. 串联字符串的最大长度

public class lc1239 {
    int ret = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (String a : arr) {
            int mask = 0;
            for (int i = 0; i < a.length(); i++) {
                int v = a.charAt(i) - 'a';
                if (((mask >> v) & 1) == 1) {
                    mask = 0;
                    break;
                }
                mask = mask | (1 << v);
            }
            if (mask > 0) {
                masks.add(mask);
            }

        }
        backtrace(masks, 0, 0);
        return ret;
    }

    private void backtrace(List<Integer> masks, int position, int mask) {
        if (position == masks.size()) {
            ret = Math.max(ret, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(position)) == 0) {
            backtrace(masks, position + 1, mask | masks.get(position));
        }
        backtrace(masks, position + 1, mask);
    }
}
