package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/letter-tile-possibilities/
// 1079. 活字印刷

public class lc1079 {
    private int ret = 0;
    private boolean[] visited;

    public int numTilePossibilities(String tiles) {
        int length = tiles.length();
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        visited = new boolean[length];
        for (int i = 1; i <= length; i++) {
            backtrace(chars, 0, i);
        }
        return ret;
    }

    private void backtrace(char[] chars, int position, int length) {
        if (position == length) {
            ret++;
            return;
        }
        for (int i = 0; i < chars.length; i++) {

            if (visited[i] || (i > 0 && !visited[i - 1] && chars[i - 1] == chars[i])) {
                continue;
            }
            visited[i] = true;
            backtrace(chars, position + 1, length);
            visited[i] = false;
        }
    }
}
