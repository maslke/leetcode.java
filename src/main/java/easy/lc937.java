package easy;

// https://leetcode-cn.com/problems/reorder-data-in-log-files/
// 937. 重新排列日志文件

import java.util.Arrays;

public class lc937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] split1 = a.split(" ", 2);
            String[] split2 = b.split(" ", 2);
            boolean digit1 = Character.isDigit(split1[1].charAt(0));
            boolean digit2 = Character.isDigit(split2[1].charAt(0));
            if (!digit1 && !digit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return split1[0].compareTo(split2[0]);
            } else {
                return digit1 ? (digit2 ? 0 : 1) : -1;
            }
        });
        return logs;
    }
}
