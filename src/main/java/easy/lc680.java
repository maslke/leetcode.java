/**
 * Author:maslke
 * Date:2017/9/24
 * Version:0.0.1
 * 680. Valid Palindrome II
 */
public class lc680 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int count = 0;
        int inx1 = 0, inx2 = 0;
        while ( i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (count == 0) {
                    inx1 = i;
                    inx2 = j;
                    count++;
                    i++;
                } else if (count == 1) {
                    count++;
                    i = inx1;
                    j= inx2 - 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
