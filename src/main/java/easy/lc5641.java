package easy;

// https://leetcode-cn.com/problems/maximum-units-on-a-truck/
// 5641. 卡车上的最大单元数

import java.util.Arrays;

public class lc5641 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {
            return b[1] - a[1];
        });
        int sum = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize <= 0) {
                break;
            }
            int n =  Math.min(boxTypes[i][0], truckSize);
            sum += boxTypes[i][1] * n;
            truckSize = truckSize - n;
        }
        return sum;
    }
}
