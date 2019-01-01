

/**
 * Author:maslke
 * Date:2017/8/21
 * Version:0.0.1
 * 58. Length of Last Word
 */
public class lc58 {
    public int lengthOfLastWord(String s) {
        int len = 0;
        if (s == null || s.isEmpty()) {
            return 0;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (len != 0) {
                    break;
                }
            } else {
                len++;
            }

        }
        return len;
    }
}
