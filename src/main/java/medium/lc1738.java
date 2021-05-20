package medium;

public class lc1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] acc = new int[m + 1][n + 1];

        int[] array = new int[(m + 1) * (n + 1)];
        int inx = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                acc[i][j] = acc[i - 1][j - 1] ^ acc[i - 1][j] ^ acc[i][j - 1] ^ matrix[i - 1][j - 1];
                array[inx++] = acc[i][j];
            }
        }

        int left = 0;
        int right = array.length - 1;
        while (true) {
            int target = findIndex(array, left, right);
            if (target == k - 1) {
                return array[target];
            }
            else if (target > k - 1) {
                right = target - 1;
            }
            else {
                left = target + 1;
            }
        }
    }

    int findIndex(int[] num, int left, int right) {
        int i = left;
        int j = right + 1;
        int a = num[left];
        while (true) {
            while (num[++i] > a) {
                if (i == right) {
                    break;
                }
            }
            while (num[--j] < a) {
                if (j == left) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }

        int temp = num[left];
        num[left] = num[j];
        num[j] = temp;
        return j;
    }
}
