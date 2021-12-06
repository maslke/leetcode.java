package easy;

public class lc1816 {
    public String truncateSentence(String s, int k) {
        int i = 0;
        int len = s.length();
        while (i < len && k > 0) {
            char c = s.charAt(i);
            if (c == ' ') {
                k--;
            }
            i++;
        }
        if (k == 0) {
            return s.substring(0, i - 1);
        } else {
            return s;
        }
    }
}
