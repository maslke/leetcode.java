package medium;

// https://leetcode-cn.com/problems/additive-number/
// 306. 累加数

public class lc306 {
    public boolean isAdditiveNumber(String num) {
        return back(num, num.length(), 0, 0, 0, 0);
    }

    private boolean back(String s, int length, int start, long sum, long prev, int count) {
        if (start == length) {
            return count >= 3;
        }
        long acc = 0;
        for (int i = start; i < length; i++) {
            if (s.charAt(start) == '0' && i > start) {
                break;
            }
            acc = acc * 10 + s.charAt(i) - '0';
            if (count >= 2) {
                if (acc < sum) {
                    continue;
                } else if (acc > sum) {
                    break;
                }
            }
            count += 1;
            if (back(s, length, i + 1, prev + acc, acc, count)) {
                return true;
            } else {
                count -= 1;
            }
        }

        return false;
    }
}
