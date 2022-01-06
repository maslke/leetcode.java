package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/flower-planting-with-no-adjacent/
// 1042. 不邻接植花
public class lc1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            list.get(path[0]).add(path[1]);
            list.get(path[1]).add(path[0]);
        }

        int[] ret = new int[n];
        for (int i = 1; i <= n; i++) {
            List<Integer> values = list.get(i);
            int[] colors = new int[4];
            for (int x : values) {
                if (ret[x - 1] > 0) {
                    colors[ret[x - 1] - 1] = 1;
                }
            }
            for (int j = 0; j < 4; j++) {
                if (colors[j] == 0) {
                    ret[i - 1] = j + 1;
                    break;
                }
            }
        }
        return ret;
    }
}
