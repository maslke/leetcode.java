package medium;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// 378. Kth Smallest Element in a Sorted Matrix
// Mark

class lc378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int middle = (right - left) / 2 + left;
            int count = count(matrix, middle);
            // 小于当前值的数组元素的个数为count，不小于k，说明了最终答案要小于等于middle
            // 小于当前值的数组元素的个数为count，小于k，说明了最终答案要大于middle
            if (count >= k) {
                right = middle;
            } else {
                left = middle - 1;
            }
        }

        return left;
    }

    private int count(int[][] matrix, int middle) {
        int i = matrix.length - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < matrix.length) {
            int value = matrix[i][j];
            if (value <= middle) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{1, 5, 9}, new int[]{10, 11, 13}, new int[]{12, 13, 15}};
    }
}