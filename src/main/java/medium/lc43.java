package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:maslke
 * Date:2017/9/5
 * Version:0.0.1
 * 43. Multiply Strings
 */
public class lc43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        List<String> rets = new ArrayList<String>();
        int index = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            String r = multiply2(num2, num1.charAt(i) - 48);
            for (int j = 0; j < index; j++) {
                r = r + "0";
            }
            index++;
            rets.add(r);
        }
        if (rets.size() == 0) {
            return "";
        }
        String v = rets.get(0);
        for (int i = 1; i < rets.size(); i++) {
            v = add(v, rets.get(i));
        }
        return v;
    }

    public String add(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int added = 0;
        int i = len1 - 1, j = len2 - 1;
        String ret = "";
        while (i >= 0 && j >= 0) {
            int v = num1.charAt(i) - 48 + num2.charAt(j) - 48;
            v = v + added;
            added = 0;
            if (v >= 10) {
                v = v - 10;
                added = 1;
            }
            ret = v + ret;
            i--;
            j--;
        }
        String temp = null;
        int k = 0;
        if (len1 > len2) {
            temp = num1;
            k = i;
        } else if (len1 < len2) {
            temp = num2;
            k = j;
        }
        if (temp != null) {
            while (k >= 0) {
                int v = temp.charAt(k) - 48;
                v = v + added;
                added = 0;
                if (v >= 10) {
                    v = v - 10;
                    added = 1;
                }
                ret = v + ret;
                k--;
            }
        }

        if (added == 1) {
            ret = "1" + ret;
        }
        return ret;
    }

    public String multiply2(String num1, int val) {
        String ret = "";
        int length = num1.length();
        int added = 0;
        for (int i = length - 1; i >= 0; i--) {
            int v1 = num1.charAt(i) - 48;
            int v = v1 * val + added;
            ret = v % 10 + ret;
            added = v / 10;
        }
        if (added != 0) {
            ret = added + ret;
        }
        return ret;
    }
}
