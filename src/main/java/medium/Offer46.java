package medium;

// https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
// 剑指Offer 46.把数字翻译成字符串

public class Offer46 {
    public int translateNum(int num) {
        return translate(String.valueOf(num));
    }

    private int translate(String s) {
        if (s.equals("")) {
            return 1;
        }
        if (s.length() == 1) {
            return 1;
        }
        if (s.substring(0, 1).equals("0")) {
            return translate(s.substring(1));
        } else {
            int count1 = translate(s.substring(1));
            String sub = s.substring(0, 2);
            int v = Integer.parseInt(sub);
            if (v > 25) {
                return count1;
            }
            return count1 + translate(s.substring(2));
        }
    }
}
