//https://leetcode.com/problems/shifting-letters/
//848. Shifting Letters

package medium;

class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        int sum = 0;
        for (int i = 0; i < shifts.length; i++) {
            sum += shifts[i] % 26;
        }
        for (int i = 0; i < chars.length; i++) {
            if ( i != 0) {
                sum = sum - shifts[i - 1] % 26;
            }
            int count = sum % 26;
            int val = chars[i] + count;
            if (val > 122) {
                chars[i] = (char)(val - 122 + 96);
            } else {
                chars[i] = (char)val;
            }
        }
        return new String(chars);
    }
}