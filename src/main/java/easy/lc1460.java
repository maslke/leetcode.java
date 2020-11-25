package easy;

import java.util.Arrays;

public class lc1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        if (target.length != arr.length) {
            return false;
        }
        return Arrays.equals(target, arr);
    }

    public boolean canBeEqual2(int[] target, int[] arr) {
        int[] values = new int[1001];
        if (target.length != arr.length) {
            return false;
        }
        for (int i = 0; i < target.length; i++) {
            values[target[i]]++;
            arr[target[i]]--;
        }

        for (int i = 0; i < values.length; i++) {
            if (values[i] != 0) {
                return false;
            }
        }

        return true;

    }
}
