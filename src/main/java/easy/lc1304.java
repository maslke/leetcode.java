package easy;

import java.util.List;
import java.util.ArrayList;

class lc1304 {
    public int[] sumZero(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
            list.add(-1 * i);
        }

        if (n % 2 != 0) {
            list.add(0);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}