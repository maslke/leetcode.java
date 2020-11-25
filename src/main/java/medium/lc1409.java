package medium;

import java.util.ArrayList;
import java.util.List;

public class lc1409 {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }

        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int inx = 0;
            while (inx < m) {
                if (list.get(inx) == queries[i]) {
                    break;
                }
                inx++;
            }
            ret[i] = inx;
            list.remove(inx);
            list.add(0, queries[i]);
        }
        return ret;
    }
}
