package easy;

// https://leetcode-cn.com/problems/find-the-difference/
// 389. 找不同

public class lc389 {

    public char findTheDifference(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            diff += (t.charAt(i) - s.charAt(i));
        }
        return (char) (diff + t.charAt(t.length() - 1));
    }

    public char findTheDifference2(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            diff ^= s.charAt(i);
            diff ^= t.charAt(i);
        }

        return (char) (diff ^ t.charAt(t.length() - 1)) ;
    }
}
