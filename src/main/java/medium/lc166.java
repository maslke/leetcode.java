package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
// 166. 分数到小数
public class lc166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        StringBuilder sb = new StringBuilder();
        if (a * b < 0) {
            a = Math.abs(a);
            b = Math.abs(b);
            sb.append("-");

        }
        Map<Long, Integer> map = new HashMap<>();
        sb.append(a / b).append(".");
        a = a % b;
        while (a != 0) {
            map.put(a, sb.length());
            a = a * 10;
            sb.append(a / b);
            a = a % b;
            if (map.containsKey(a)) {
                int inx = map.get(a);
                return String.format("%s(%s)", sb.substring(0, inx), sb.substring(inx));
            }
        }
        return sb.toString();
    }
}
