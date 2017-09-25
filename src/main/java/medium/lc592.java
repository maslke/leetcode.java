package medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Author:maslke
 * Date:2017/9/25
 * Version:0.0.1
 * 592. Fraction Addition and Subtraction
 */
public class lc592 {
    public String fractionAddition(String expression) {
        expression = expression.replaceAll("\\-", "\\+-");
        if (expression.startsWith("+")) {
            expression = expression.substring(1);
        }
        String[] parts = expression.split("\\+");
        int num1 = 1;
        for (int i = 0; i < parts.length; i++) {
            num1 *= Integer.valueOf(parts[i].split("\\/")[1]);
        }
        int num2 = 0;
        for (int i = 0; i < parts.length; i++) {
            String[] p2 = parts[i].split("\\/");
            num2 += Integer.valueOf(p2[0]) * num1 / Integer.valueOf(p2[1]);
        }
        if (num2 == 0) {
            return "0/1";
        }
        int a = Math.max(Math.abs(num1), Math.abs(num2));
        int b = Math.min(Math.abs(num1), Math.abs(num2));
        int r = gcd(a, b);
        String ret = (num2 / r) + "/" + (num1 / r);
        return ret;
    }
    private int gcd(int v1, int v2) {
        if (v1 % v2 == 0) {
            return v2;
        } else {
            return gcd(v2, v1 % v2);
        }

    }
}
