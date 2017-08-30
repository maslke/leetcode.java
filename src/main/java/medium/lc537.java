package medium;

/**
 * Author:maslke
 * Date:2017/8/30
 * Version:0.0.1
 * 537. Complex Number Multiplication
 */
public class lc537 {
    public String complexNumberMultiply(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        int inx1 = a.indexOf("+");
        int length1 = a.length();
        int inx2 = b.indexOf("+");
        int length2 = b.length();
        String a1 = a.substring(0, inx1);
        String a2 = a.substring(inx1 + 1, length1 - 1);
        String b1 = b.substring(0, inx2);
        String b2 = b.substring(inx2 + 1, length2 - 1);
        Integer p1 = Integer.valueOf(a1) * Integer.valueOf(b1);
        Integer p2 = -1 * Integer.valueOf(a2) * Integer.valueOf(b2);
        Integer p3 = Integer.valueOf(a1) * Integer.valueOf(b2);
        Integer p4 = Integer.valueOf(a2) * Integer.valueOf(b1);
        return String.valueOf(p1 + p2) + "+" + (p3 + p4) + "i";
    }
}
