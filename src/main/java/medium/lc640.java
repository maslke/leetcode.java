package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/9/12
 * Version:0.0.1
 * 640. Solve the Equation
 */
public class lc640 {
    public String solveEquation(String equation) {
        String[] parts = equation.split("\\=");
        List<String> v1 = analysis(parts[0]);
        List<String> v2 = analysis(parts[1]);
        int inx = Integer.valueOf(v1.get(0)) - Integer.valueOf(v2.get(0));
        int v = Integer.valueOf(v2.get(1)) - Integer.valueOf(v1.get(1));
        if (inx == 0 && v != 0) {
            return "No solution";
        } else if (inx == 0) {
            return "Infinite solutions";
        } else {
            return String.valueOf("x=" + (v / inx));
        }
    }

    private List<String> analysis(String s) {
        Stack<String> stack = new Stack<String>();
        int length = s.length();
        int index1 = 0;
        int i = 0;
        while (i < length) {
            String c = s.substring(i, i + 1);
            if (c.matches("\\d")) {
                int k = i;
                String temp = "";
                for (; k < length; k++) {
                    temp = s.substring(k, k + 1);
                    if (!temp.matches("\\d")) {
                        break;
                    }
                }
                String p = s.substring(i, k);
                if (temp.equals("x")) {
                    if (stack.isEmpty()) {
                        index1 += Integer.valueOf(p);
                    } else {
                        String o = stack.pop();
                        if (o.equals("+")) {
                            index1 += Integer.valueOf(p);
                        } else {
                            index1 -= Integer.valueOf(p);
                        }
                    }
                    k = k + 1;
                } else {
                    if (stack.isEmpty()) {
                        stack.push(p);
                    } else {
                        String o = stack.pop();
                        if (stack.isEmpty()) {
                            if (o.equals("+")) {
                                stack.push(p);
                            } else {
                                stack.push("-" + p);
                            }
                        } else {
                            String n = stack.pop();
                            if (o.equals("+")) {
                                int v = Integer.valueOf(n) + Integer.valueOf(p);
                                stack.push(String.valueOf(v));
                            } else {
                                int v = Integer.valueOf(n) - Integer.valueOf(p);
                                stack.push(String.valueOf(v));
                            }
                        }
                    }
                }
                i = k;
            } else if (c.equals("+") || c.equals("-")) {
                stack.push(c);
                i++;
            } else if (c.equals("x")) {
                if (stack.isEmpty()) {
                    index1 += 1;
                } else {
                    String o = stack.pop();
                    if (o.equals("+")) {
                        index1 += 1;
                    } else {
                        index1 -= 1;
                    }
                }
                i++;
            }
        }
        List<String> ret = new ArrayList<String>();
        ret.add(String.valueOf(index1));
        if (stack.isEmpty()) {
            ret.add("0");
        } else {
            ret.add(stack.pop());
        }
        return ret;
    }
}
