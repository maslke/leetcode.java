package easy;

/**
 * Author:maslke
 * Date:2017/9/1
 * Version:0.0.1
 * 342. Power of Four
 * 不知道我的这种方法又没有违反 不能使用循环和递归 的规定
 */
public class lc342 {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        String s = Integer.toBinaryString(num);
        int length = s.length();
        boolean has = false;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(length - 1 - i);
            if (c == '1') {
                if (has || i % 2 == 1) {
                    return false;
                } else {
                    has = true;
                }
            }
        }
        return has;
    }
}
