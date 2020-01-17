package easy;

class lc985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                sum += A[i];
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            int v = A[index];
            if (v % 2 == 0) {
                if (val % 2 == 0) {
                    result[i] = sum + val;
                } else {
                    result[i] = sum - A[index];
                }
                sum = result[i];
            } else {
                if (val % 2 != 0) {
                    result[i] = sum + val + A[index];
                    sum = result[i];
                } else {
                    result[i] = sum;
                }
            }
            A[index] += val;

        }
        return result;
    }
}