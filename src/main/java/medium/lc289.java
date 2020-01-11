package medium;

class lc289 {
    // (0 -> 1) -> 2
    // (1 -> 0) -> -1
    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int aliveCount = getAliveCount(board, i, j);
                if (board[i][j] == 0) {
                    if (aliveCount == 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 1) {
                    if (aliveCount < 2 || aliveCount > 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private boolean isAlive(int[][] board, int i, int j) {
        return board[i][j] == 1 || board[i][j] == -1;
    }

    private int getAliveCount(int[][] board, int i, int j) {
        int result = 0;
        if (i - 1 >= 0 && j - 1 >= 0 && isAlive(board, i - 1, j - 1)) {
            result += 1;
        }
        if (i - 1 >= 0 && isAlive(board, i - 1, j)) {
            result += 1;
        }
        if (i - 1 >= 0 && j + 1 < board[i].length && isAlive(board, i - 1, j + 1)) {
            result += 1;
        }
        if (j - 1 >= 0 && isAlive(board, i, j - 1)) {
            result += 1;
        }

        if (j + 1 < board[i].length && isAlive(board, i, j + 1)) {
            result += 1;
        }
        if (i + 1 < board.length && j - 1 >= 0 && isAlive(board, i + 1, j - 1)) {
            result += 1;
        }
        if (i + 1 < board.length && isAlive(board, i + 1, j)) {
            result += 1;
        }
        if (i + 1 < board.length && j + 1 < board[i].length && isAlive(board, i + 1, j + 1)) {
            result += 1;
        }
        return result;
    }
}