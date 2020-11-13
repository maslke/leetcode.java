package hard;

public class lc52 {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        dfs(chars, 0);
        return count;
    }

    private void dfs(char[][] chars, int row) {

        int length = chars.length;
        if (row == length) {
            count++;
            return;
        }
        for (int i = 0; i < length; i++) {
            if (valid(chars, row, i)) {
                chars[row][i] = 'Q';
                dfs(chars, row + 1);
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
}
