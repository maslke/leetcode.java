package medium;

// https://leetcode-cn.com/problems/valid-tic-tac-toe-state/
// 793. 有效的井字游戏
public class lc794 {
    public boolean validTicTacToe(String[] board) {
        char[][] chars = new char[3][3];
        int countx = 0, counto = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char c = board[i].charAt(j);
                chars[i][j] = c;
                if (c == 'X') {
                    countx++;
                }
                else if (c == 'O') {
                    counto++;
                }
            }
        }
        if (countx - counto > 1 || counto > countx) {
            return false;
        }
        if (success(chars, 'X') && success(chars, 'O')) {
            return false;
        }
        if (success(chars, 'X') && counto == countx) {
            return false;
        }
        return !success(chars, 'O') || countx != counto + 1;

    }

    private boolean success(char[][] chars, char c) {
        for (int i = 0; i < 3; i++) {
            if (chars[i][0] == c && chars[i][1] == c && chars[i][2] == c) {
                return true;
            }
            if (chars[0][i] == c && chars[1][i] == c && chars[2][i] == c) {
                return true;
            }
        }

        return (chars[0][0] == c && chars[1][1] == c && chars[2][2] == c) || (chars[0][2] == c && chars[1][1] == c && chars[2][0] == c);

    }
}
