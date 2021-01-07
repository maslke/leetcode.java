package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/queens-that-can-attack-the-king/
// 1222. 可以攻击国王的皇后

public class lc1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ret = new ArrayList<>();
        int a = king[0];
        int b = king[1];

        int[][] q = new int[8][8];
        for (int i = 0; i < queens.length; i++) {
            q[queens[i][0]][queens[i][1]] = 1;
        }

        int[][] moves = new int[][] {new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}
                , new int[]{1, 1}, new int[]{-1, -1}, new int[]{1, -1}, new int[]{-1, 1}};
        for (int i = 0; i < moves.length; i++) {
            int x = a;
            int y = b;
            while (true) {
                x += moves[i][0];
                y += moves[i][1];
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (q[x][y] == 1) {
                        addToResult(ret, x, y);
                        break;
                    }
                } else {
                    break;
                }

            }
        }
        return ret;
    }

    private void addToResult(List<List<Integer>> ret, int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        ret.add(list);
    }
}
