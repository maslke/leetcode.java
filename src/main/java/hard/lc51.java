package hard;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/n-queens/
// 51. N皇后
public class lc51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        List<List<String>> ret = new ArrayList<>();
        dfs(chars, 0, ret);
        return ret;
    }

    private void dfs(char[][] chars, int row, List<List<String>> ret) {

        int length = chars.length;
        if (row == length) {
            ret.add(compose(chars));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (valid(chars, row, i)) {
                chars[row][i] = 'Q';
                dfs(chars, row + 1, ret);
                chars[row][i] = '.';
            }
        }
    }

    private boolean valid(char[][] chars, int row, int col) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == 'Q' && (row == i || col == j)) {
                    return false;
                }

                if (chars[i][j] == 'Q' && Math.abs(i - row) == Math.abs(j - col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> compose(char[][] chars) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            ret.add(new String(chars[i]));
        }
        return ret;
    }
}
