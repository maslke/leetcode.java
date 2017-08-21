package easy;

/**
 * Author:maslke
 * Date:2017/8/20
 * Version:0.0.1
 * 415. Add Strings
 */
public class lc415 {
    public String addStrings(String num1, String num2) {
        if (num1.equals("0")) {
            return num2;
        }
        if (num2.equals("0")) {
            return num1;
        }

        int len1 = num1.length();
        int len2 = num2.length();
        boolean flag = false;
        int len = len1 < len2 ? len2 : len1;
        String result = "";
        for (int i = len - 1; i >= 0 ;i--) {
            int sum;
            if (len == len1) {
                if (i - (len1 - len2) >= 0) {
                    sum = num1.charAt(i) - 48 + num2.charAt(i - (len1 - len2)) - 48;
                } else {
                    sum = num1.charAt(i) - 48;
                }
            } else {
                if (i - (len2 - len1) >= 0) {
                    sum = num1.charAt(i - (len2 - len1)) - 48 + num2.charAt(i) - 48;
                } else {
                    sum = num2.charAt(i) - 48;
                }
            }
            if (flag) {
                sum = sum + 1;
            }
            if (sum >= 10) {
                flag = true;
                result = "" + (sum - 10) + result;
            } else {
                flag = false;
                result = "" + sum + result;
            }
        }
        if (flag) {
            result = "1" + result;
        }
        return result;
    }
}
