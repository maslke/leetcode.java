package easy;

import java.util.Arrays;

public class lc1646 {
    public int getMaximumGenerated(int n) {
        int[] values = new int[n + 1];
        values[0] = 0;
        values[1] = 1;
        values[2] = 1;
        for (int i = 2; i <= n; i++) {
            if(i % 2 == 0) {
                values[i] = values[i / 2];
            } else {
                values[i] = values[i / 2 + 1] + values[i / 2];
            }
        }
        return Arrays.stream(values).max().getAsInt();
    }
}
