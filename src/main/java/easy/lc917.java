package easy;

/**
 * 917. Reverse Only Letters
 * Date: 2018/12/27
 * easy   
 */

 public class lc917 {

     private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;
        char[] chars = S.toCharArray();
        while (i < j) {
            if (!isLetter(chars[i])) {
                i++;
                continue;
            }
            if (!isLetter(chars[j])) {
                j--;
                continue;
            }
            swap(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }

 }