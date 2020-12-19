package medium;

// https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
// 1689. 十-二进制数的最少数目

public class lc1689 {
    public int minPartitions(String n) {
        char[] chars = n.toCharArray();
        int count = 0;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != '0') {
                    flag = true;
                    chars[i]--;
                }
            }
            if (!flag) {
                break;
            }
            count++;
        }
        return count;

    }
}
