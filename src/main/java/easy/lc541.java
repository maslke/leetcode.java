package easy;

// https://leetcode-cn.com/problems/reverse-string-ii/
// 541. 反转字符串II
public class lc541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int start = 0;
        while (start < len) {
            int left = len - start;
            if (left < k) {
                revert(chars, start, len - 1);
                break;
            }
            else {
                revert(chars, start, start + k - 1);
                start = start + 2 * k;
            }
        }

        return new String(chars);
    }

    private void revert(char[] chars, int left, int right) {
        int i = left;
        int j = right;

        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
