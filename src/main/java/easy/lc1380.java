package easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/lucky-numbers-in-a-matrix/
// 1380. Lucky Numbers in a Matrix

class lc1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        if (matrix.length == 0) return new ArrayList<>();
        
        List<Integer> mins = new ArrayList<>();
        List<Integer> maxs = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                }
                
            }
            mins.add(min);
        }
        
        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                if (max < matrix[j][i]) {
                    max = matrix[j][i];
                } 
                
            }
            maxs.add(max);
        }
        
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (mins.get(i) == matrix[i][j] && maxs.get(j) == matrix[i][j]) {
                    ret.add(matrix[i][j]);
                }
            }
        }
        
        return ret;
        
        
    }
    
    
}