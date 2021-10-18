package easy;

// https://leetcode-cn.com/problems/count-and-say/
// 38. 外观数列

public class lc38 {
    public String countAndSay(int n) {

        String prev = "1";
        for (int i = 2; i <= n; i++) {
            String last = convert(prev);
            prev = last;

        }
        return prev;
    }

    private String convert(String prev) {
        StringBuilder sb = new StringBuilder();
        if (prev.length() == 1) {
            sb.append("1").append(prev);
            return sb.toString();
        }
        int i = 0;
        int len = prev.length();
        while (i < len) {
            int j = i;
            while (j < len && prev.charAt(j) == prev.charAt(i)) {
                j++;
            }
            sb.append(j - i).append(prev.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}
