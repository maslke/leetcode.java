package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

public class lc1893 {

    public boolean isCovered2(int[][] ranges, int left, int right) {
        BitSet bitSet = new BitSet();
        for (int[] range : ranges) {
            bitSet.set(range[0], range[1] + 1);
        }
        int next = bitSet.nextClearBit(left);
        return next > right;
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        List<int[]> values = new ArrayList<>(Arrays.asList(ranges));
        values.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<int[]> list = new ArrayList<>();
        int[] current = new int[2];
        current[0] = values.get(0)[0];
        current[1] = values.get(0)[1];
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i)[0] > current[1] + 1) {
                list.add(current);
                current[0] = values.get(i)[0];
                current[1] = values.get(i)[1];
            } else {
                current[1] = Math.max(current[1], values.get(i)[1]);
            }
        }
        list.add(current);
        for (int[] range : list) {
            if (range[0] <= left && range[1] >= right) {
                return true;
            }
        }
        return false;


    }
}
