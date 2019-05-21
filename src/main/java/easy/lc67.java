package easy;

/**
 * Author:maslke
 * Date:2017/8/26
 * Version:0.0.1
 * 67. Add Binary
 */
public class lc67 {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        int len1 = a.length();
        int len2 = b.length();
        int i, j;
        boolean flag = false;
        String ret ="";
        for(i = len1 - 1, j = len2 - 1; i >= 0 && j >= 0; i--, j--) {
            int sum = a.charAt(i) + b.charAt(j) - 96;
            if (flag) {
                sum += 1;
                flag = false;
            }
            if (sum == 0 || sum == 1) {
                ret = sum + ret;
            } else if (sum == 2 || sum == 3) {
                sum = sum - 2;
                flag = true;
                ret = sum + ret;
            }
        }
        if (i < 0 && j < 0) {
            if (flag) {
                ret = "1" + ret;
                return ret;
            }
        } else {
            String temp = "";
            int x;
            if (i >= 0) {
                temp = a;
                x = i;
            } else {
                temp =b;
                x = j;
            }
            for (int m = x; m >= 0; m--) {
                int sum = temp.charAt(m) - 48;
                if (flag) {
                    sum += 1;
                    flag = false;
                }
                if (sum == 0 || sum == 1) {
                    ret = sum + ret;
                } else if (sum == 2 || sum == 3) {
                    sum = sum - 2;
                    flag = true;
                    ret = sum + ret;
                }
            }
        }
        if (flag) {
            return "1" + ret;
        } else {
            return ret;
        }
    }
}


//a better solution
class Solution {
    public String addBinary(String a, String b) {
        String ret = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean addOne = false;
        while (i >= 0 || j >= 0) {
            int v = 0;
            if (i >= 0) {
                v += Integer.valueOf(a.substring(i, i + 1));
            }
            if (j >= 0) {
                v += Integer.valueOf(b.substring(j, j + 1));
            }
            if (addOne) {
                v += 1;
                addOne = false;
            }
            if (v >= 2) {
                v -= 2;
                addOne = true;
            }
            ret = v + ret;
            i--;
            j--;
        }
        if (addOne) {
            ret = "1" + ret;
        }
        return ret;
    }
}
