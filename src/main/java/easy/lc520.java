package easy;

/**
 * Author:maslke
 * Date:2017/8/29
 * Version:0.0.1
 * 520. Detect Capital
 */
public class lc520 {
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        if (word.toUpperCase().equals(word) || word.toLowerCase().equals(word)) {
            return true;
        }
        char first = word.charAt(0);
        if (first >= 'a' && first <= 'z') {
            return false;
        }
        String temp = word.substring(1);
        return temp.toLowerCase().equals(temp);
    }
}
