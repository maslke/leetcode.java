package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/sort-the-matrix-diagonally/
// 1329. Sort the Matrix Diagonally

class lc1329 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            
            int a = i;
            int b = 0;
            List<Integer> line = new ArrayList<>();
            while (a < m && b < n) {
                line.add(mat[a++][b++]);
            }
            Collections.sort(line);
            
            a = i;
            b = 0;
            int inx = 0;
            while (a < m && b < n) {
                mat[a++][b++] = line.get(inx++);
            }
        }
        
        for (int i = 0; i < n; i++) {
            int a = 0;
            int b = i;
            List<Integer> line = new ArrayList<>();
            while (a < m && b < n) {
                line.add(mat[a++][b++]);
            }
            Collections.sort(line);
            a = 0;
            b = i;
            int inx = 0;
            while (a < m && b < n) {
                mat[a++][b++] = line.get(inx++);
            }
        }
        return mat;
        
    }
}