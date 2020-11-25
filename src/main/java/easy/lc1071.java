package easy;

// https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
// 1071. 字符串的最大公因子

class lc1071 {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int g = l1 > l2 ? gcd(l1, l2) : gcd(l2, l1);
        for (int i = g; i > 0; i--) {
            String part = str1.substring(0, i);
            if (check(str1, part) && check(str2, part)) return part;
        }
        return "";

    }

    private boolean check(String s, String part) {
        int m = s.length() / part.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            sb.append(part);
        }
        return s.equals(sb.toString());
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}