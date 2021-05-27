package medium;

// 1442. 形成两个异或相等数组的三元组数目
public class lc1442 {
    public int countTriplets(int[] arr) {
        // v[i] = 0, i = 0
        // v[i] = v[i - 1], i != 0
        // v[i] = a[0] ^ a[1] ^ a[2] ^ .... ^ a[i - 1]
        // v[i] ^ v[j] = a[i] ^ a[i + 1] ^ ... a[j - 1] == a
        // v[j] ^ v[k + 1] = a[j] ^ a[j + 1] ^ ... a[k] == b
        // v[i] ^ v[k + 1] = 0
        // v[i] == v[k + 1]
        int n = arr.length;
        int[] v = new int[n + 1];
        for (int i = 0; i < n; i++) {
            v[i + 1] = v[i] ^ arr[i];
        }


        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (v[i] == v[k + 1]) {
                    count += k - i;
                }
            }

        }

        return count;
    }

    public int countTriplets2(int[] arr) {
        int n = arr.length;
        int[][] v = new int[n][n];

        for (int i = 0; i < n; i++) {
            v[i][i] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                v[i][j] = v[i][j - 1] ^ arr[j];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (v[i][j] == 0) {
                    for (int k = i + 1; k <= j; k++) {
                        if (v[k][j] == (v[i][k] ^ arr[k])) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
