package medium;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 74. Search a 2D Matrix
 */
public class lc74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int column = matrix[0].length;
        if (column == 0) {
            return false;
        }
        int i = 0, j = 0;
        while (i < row) {
            if (matrix[i][column - 1] < target) {
                i++;
            } else {
                break;
            }

        }
        if (i == row) {
            return false;
        } else {
            return find(matrix[i], target);
        }
    }

    private boolean find(int[] values, int target) {
        int left = 0;
        int right = values.length - 1;
        return find(values, left, right, target);

    }

    private boolean find(int[] values, int left, int right, int target) {
        if (left >= right) {
            if (values[left] == target) {
                return true;
            } else {
                return false;
            }
        }
        int mid = left + (right - left) / 2;
        if (values[mid] == target) {
            return true;
        } else if (values[mid] < target) {
            return find(values, mid + 1, right, target);
        } else {
            return find(values, left, mid - 1, target);
        }
    }
}
