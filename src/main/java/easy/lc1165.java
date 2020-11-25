package easy;

// https://leetcode-cn.com/problems/single-row-keyboard/
// 1165. 单行键盘

class lc1165 {
    public int calculateTime(String keyboard, String word) {
        int sum = 0;
        int start = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int position = keyboard.indexOf(c);
            sum += Math.abs(position - start);
            start = position;
        }
        return sum;
    }
}