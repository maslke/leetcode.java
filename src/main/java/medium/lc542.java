package medium;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/01-matrix/
// 542. 01矩阵

class lc542 {

    class Node {
        int i; 
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] updateMatrix2(int[][] matrix) {
        int[][] ret = new int[matrix.length][matrix[0].length];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Node(i, j));
                }
            }
        }
        int[] diffx = new int[] {0, 0, 1, -1};
        int[] diffy = new int[] {1, -1, 0, 0};
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int inx = 0; inx < size; inx++) {
                Node node = queue.poll();
                int x = node.i;
                int y = node.j;
                for (int i = 0; i < 4; i++) {
                    int x1 = x + diffx[i];
                    int y1 = y + diffy[i];
                    if (x1 >= 0 && y1 >= 0 && x1 < matrix.length && y1 < matrix[0].length && matrix[x1][y1] == 1) {
                        ret[x1][y1] = step;
                        matrix[x1][y1] = 0;
                        queue.offer(new Node(x1, y1));
                    }
                }
            }
            
        }
        return ret;
    }


    public int[][] updateMatrix(int[][] matrix) {
        int[][] ret = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    ret[i][j] = 10000;  
                }
                if (i > 0) {
                        ret[i][j] = Math.min(ret[i][j], ret[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        ret[i][j] = Math.min(ret[i][j], ret[i][j - 1] + 1);
                    }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (i < matrix.length - 1) {
                        ret[i][j] = Math.min(ret[i][j], ret[i + 1][j] + 1);
                    }
                    if (j < matrix[i].length - 1) {
                        ret[i][j] = Math.min(ret[i][j], ret[i][j + 1] + 1);
                    }
        
            }
        }
        return ret;
    }
}