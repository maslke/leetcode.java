package easy;

class lc1252 {
    public int oddCells(int n, int m ,int[][] indices) {
        int oddCounts = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int k = 0; k < indices.length; k++) {
                    if (indices[k][0] == i) {
                        sum += 1;
                    }
                    if (indices[k][1] == j) {
                        sum += 1;
                    }
                }
                oddCounts += sum % 2;
            }
        }
        return oddCounts;
    }
}