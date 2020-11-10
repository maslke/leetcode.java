package easy;

public class lc0103 {
    public String replaceSpaces(String S, int length) {
        int count = 0;
        char[] chars = S.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                count++;
            }
        }
        int len = length + count * 2;
        int current = len - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[current] = '0';
                chars[current - 1]  = '2';
                chars[current - 2] = '%';
                current = current - 3;
            } else {
                chars[current] = chars[i];
                current = current - 1;
            }

        }
        return new String(chars).substring(0, len);
    }
}
