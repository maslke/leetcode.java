package easy;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 * 541. Reverse String II
 */
public class lc541 {
    public String reverseStr(String s, int k) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int loop = length / k;
        for (int i = 0; i < loop; i= i + 2) {
            int start = i * k;
            int end = (i + 1) * k - 1;
            while (start <= end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        if (length % k != 0) {
            if (loop % 2 == 0) {
                int start = loop * k;
                int end = length  - 1;
                while (start <= end) {
                    char temp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = temp;
                    start++;
                    end--;
                }
            }
        }
        return new String(chars);
    }
}
