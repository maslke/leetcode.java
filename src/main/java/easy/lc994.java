package easy;

class lc994 {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        while (true) {
            boolean changed = false;
            int wasGoodOne = 0;
            int goodOne = 0;
            count++;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        wasGoodOne++;
                        if (changedToRotten(grid, i, j)) {
                            grid[i][j] = -2;
                            changed = true;
                        } else {
                            goodOne++;
                        }
                    }
                }
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == -2) {
                        grid[i][j] = 2;
                    }
                }
            }

            if (wasGoodOne == 0) {
                count = 0;
                break;
            }
            if (goodOne == 0) {
                break;
            }
            if (!changed && goodOne > 0) {
                count = -1;
                break;
            }
            
        }
        return count;
    }

    private boolean changedToRotten(int[][] grid, int i, int j) {
        if (i - 1 >= 0 && grid[i - 1][j] == 2) {
            return true;
        }

        if (i + 1 <= grid.length - 1 && grid[i + 1][j] == 2) {
            return true;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 2) {
            return true;
        }
        if (j + 1 <= grid[i].length - 1 && grid[i][j + 1] == 2) {
            return true;
        }
        return false;
    }
}