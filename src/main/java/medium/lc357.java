package medium;

// https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
// 357. 计算各个位数不同的数字个数

public class lc357 {
    public int countNumbersWithUniqueDigits(int n) {
        int sum  = 1;
        for (int i = 1; i <= n; i++) {
            int a = 1;
            int begin = 9;
            boolean flag = true;
            for (int j = 1; j <= i; j++) {
                a = a * begin;
                if (!flag) {
                    begin--;
                }
                flag = false;
                if (begin < 1) {
                    break;
                }


            }
            sum += a;
        }
        return sum;
    }
}
