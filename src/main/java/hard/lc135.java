package hard;

// https://leetcode-cn.com/problems/candy/
// 135. 分发糖果

public class lc135 {
    public int candy(int[] values) {
        int init = 1;
        int i = 0;
        int count = 0;
        while (i < values.length) {
            if (i == values.length - 1) {
                count += init;
                break;
            }
            if (values[i + 1] == values[i]) {
                count += init;
                init = 1;
                i++;
            } else if (values[i + 1] > values[i]) {
                count += init;
                init++;
                i++;
            } else {
                int j = i;
                while (j + 1 < values.length && values[j + 1] < values[j]) {
                    j++;
                }
                int n = j - i + 1;
                count += n * (n + 1) / 2;
                if (n < init) {
                    count += (init - n);
                }
                count--;
                i = j;
                init = 1;

            }
        }
        return count;
    }
}
