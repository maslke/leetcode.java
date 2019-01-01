/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 125. Valid Palindrome
 */
public class lc125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int len = s.length();
        int i = 0, j = len - 1;
        while (i <= j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (!((left >= 'a' && left <= 'z') || (left >= 'A' && left <= 'Z') || (left >= '0' && left <= '9'))) {
                i++;
                continue;
            }
            if (!((right >= 'a' && right <= 'z') || (right >= 'A' && right <= 'Z') || (right >= '0' && right <= '9'))){
                j--;
                continue;
            }
            if (!Character.toString(left).equalsIgnoreCase(Character.toString(right))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
