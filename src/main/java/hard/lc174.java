package hard;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 */
public class lc174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] values = new int[row][column];
        if (dungeon[row - 1][column - 1] >= 0) {
            values[row - 1][column - 1] = 0;
        } else {
            values[row - 1][column - 1] = 0 - dungeon[row - 1][column - 1];
        }
        for (int i = column - 2; i >= 0; i--) {
            int v = values[row - 1][i + 1] - dungeon[row - 1][i];
            if (v < 0) {
                v = 0;
            }
            values[row - 1][i] = v;

        }
        for (int i = row - 2; i >= 0; i--) {
            int v = values[i + 1][column - 1] - dungeon[i][column - 1];
            if (v < 0) {
                v = 0;
            }
            values[i][column - 1] = v;
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                int v1 = values[i + 1][j];
                int v2 = values[i][j + 1];
                int v = Math.min(v1 - dungeon[i][j], v2 - dungeon[i][j]);
                if (v < 0) {
                    v = 0;
                }
                values[i][j] = v;
            }
        }
        return values[0][0] + 1;
    }
}
