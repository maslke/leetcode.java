package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 36. Valid Sudoku
 */
public class lc36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!validRow(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!validColumn(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!validRec(board, i , j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validRec(char[][] board, int i, int j) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int m = i * 3; m < i * 3 + 3 ; m++) {
            for (int n = j * 3; n < j * 3 + 3; n++) {
                if (board[m][n] == '.') {
                    continue;
                }
                int val = board[m][n] - 48;
                if (val >= 0 && val <= 9) {
                    if (map.containsKey(val)) {
                        return false;
                    } else {
                        map.put(val, 1);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validColumn(char[][] board, int i) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int j = 0; j < 9; j++) {
            if (board[j][i] == '.') {
                continue;
            }
            int val = board[j][i] - 48;
            if (val >= 0 && val <= 9) {
                if (map.containsKey(val)) {
                    return false;
                } else {
                    map.put(val, 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean validRow(char[][] board, int i) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
                continue;
            }
            int val = board[i][j] - 48;
            if (val >= 0 && val <= 9) {
                if (map.containsKey(val)) {
                    return false;
                } else {
                    map.put(val, 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
