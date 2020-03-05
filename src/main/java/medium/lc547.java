package medium;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/friend-circles/
// 547. Friend Circles
class lc547 {
    public int findCircleNum(int[][] M) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < M.length; i++) {
          if (set.contains(i)) {
              continue;
          } else {
              count++;
              visit(M, i, set);
          }
        }  
        return count;
    }
    
    private void visit(int[][] M, int i, Set<Integer> set) {
        int[] v = M[i];
        set.add(i);
        for (int inx = 0; inx < v.length; inx++) {
            if (v[inx] == 1 && !set.contains(inx)) {
                visit(M, inx, set);
            }
        }
    }
}