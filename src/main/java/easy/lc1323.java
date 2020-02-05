package easy;

// https://leetcode.com/contest/weekly-contest-172/problems/maximum-69-number/
// 1323. Maximum 69 Number

class lc1323 {
    public int maximum69Number (int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(chars));
    }
}