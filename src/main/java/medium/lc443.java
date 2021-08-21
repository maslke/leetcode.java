package medium;

public class lc443 {
    public int compress(char[] chars) {
        int i = 0;
        int len = chars.length;
        while (i < len) {
            int j = i + 1;
            while (j < len && chars[j] == chars[i]) {
                j++;
            }
            if (j != i + 1) {

                String  s = String.valueOf(j - i);
                int l = s.length();
                for (int m = 0; m < l; m++) {
                    chars[i + m + 1] = s.charAt(m);
                }


                if (j - i - l - 1 != 0) {
                    for (int m = j; m < len; m++) {
                        chars[m - (j - i - l - 1)] = chars[m];
                    }
                }

                len = len - (j - i - l - 1);
                i += l + 1;
            } else {
                i = j;
            }
        }
        return len;
    }
}
