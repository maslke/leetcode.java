package medium;

class lc73 {
    public void setZeros(int[][] matrix) {
        int reserveValue = -1024;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0 && hasZero(matrix, i, j)) {
                    matrix[i][j] = reserveValue;
                }
            }
        }

        // 另外一种可行的方式
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         if (matrix[i][j] == 0) {
        //             setZero(matrix, i, j);
        //         }
        //     }
        // }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == reserveValue) {
                    matrix[i][j] = 0;
                }
            }
        }

    
    }

    // 将matrix中不为0的数字，设置为特征值
    private void setZero(int[][] matrix, int i, int j) {
        for (int m = 0; m < matrix[i].length; m++) {
            if (matrix[i][m] != 0) {
                matrix[i][m] = -1024;
            }
        }

        for (int m = 0; m < matrix.length; m++) {
            if (matrix[m][j] != 0) {
                matrix[m][j] = -1024;
            }
        }
    }

    private boolean hasZero(int[][] matrix, int i, int j) {
        for (int m = 0; m < matrix[i].length; m++) {
            if (matrix[i][m] == 0) {
                return true;
            }
        }

        for (int m = 0; m < matrix.length; m++) {
            if (matrix[m][j] == 0) {
                return true;
            }
        }

        return false;
    }
}