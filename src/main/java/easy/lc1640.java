package easy;

public class lc1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        boolean[] flag = new boolean[arr.length];
        for (int i = 0; i < pieces.length; i++) {
            if (!mark(arr, flag, pieces[i])) {
                return false;
            }
        }
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean mark(int[] arr, boolean[] flag, int[] piece) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == piece[0]) {
                int k = i;
                int j = 0;
                while (k < arr.length && j < piece.length) {
                    if (arr[k] != piece[j] || flag[k]) {
                        return false;
                    }
                    flag[k] = true;
                    k++;
                    j++;
                }
                if (j != piece.length) {
                    return false;
                }
            }
        }
        return true;
    }
}
