package main.easy;

/**
 * Author:maslke
 * Date:2017/8/17
 * Version:0.0.1
 * 657. Judge Route Circle
 */
public class lc657 {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.isEmpty()) {
            return true;
        }
        char[] chars = moves.toCharArray();
        new String(chars);
        int x = 0, y = 0;
        int length = moves.length();
        for (int i = 0; i < length; i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'L') {
                x--;
            } else if (c == 'R') {
                x++;
            }
        }
        return x == 0 && y == 0;
    }
}
