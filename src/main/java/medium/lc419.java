package medium;

//https://leetcode-cn.com/problems/battleships-in-a-board/
// 419. 甲板上的战舰

public class lc419 {
    public int countBattleships(char[][] board) {
        int ret = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    for (int col = j + 1; col < board[i].length; col++) {
                        if (board[i][col] == '.') {
                            break;
                        }
                        board[i][col] = '.';
                    }
                    for (int row = i + 1; row < board.length; row++) {
                        if (board[row][j] == '.') {
                            break;
                        }
                        board[row][j] = '.';
                    }
                    ret++;
                }

            }
        }
        return ret;
    }
}
