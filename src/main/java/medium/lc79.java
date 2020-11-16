package medium;

// https://leetcode-cn.com/problems/word-search/
// 79. 单词搜索

public class lc79 {
    public boolean exist(char[][] board, String word) {
        boolean ret = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ret = dfs(board, i, j, word, 0);
                if (ret) {
                    return ret;
                }
            }
        }
        return ret;
    }


    private boolean dfs(char[][] board, int i, int j, String word, int inx) {
        if (inx >= word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '.') {
            return false;
        }
        if (board[i][j] != word.charAt(inx)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '.';

        boolean ret = dfs(board, i + 1, j, word, inx + 1) || dfs(board, i - 1, j, word, inx + 1)
                || dfs(board, i, j + 1, word, inx + 1) || dfs(board, i, j - 1, word, inx + 1);
        board[i][j] = temp;
        return ret;

    }
}
