package easy;

import java.util.ArrayList;
import java.util.List;

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 */
 class CustomFunction {
      // Returns f(x, y) for any given positive integers x and y.
      // Note that f(x, y) is increasing with respect to both x and y.
      // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
      int f(int x, int y) {
          return 0;
      }
  };

public class lc1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ret = new ArrayList<>();
        int x = 1;
        int y = 1000;
        while (x <= 1000 && y >= 1) {
            int m = customfunction.f(x, y);
            if (m == z) {
                List<Integer> xy = new ArrayList<>();
                xy.add(x);
                xy.add(y);
                x++;
                y--;
                ret.add(xy);
            } else if (m < z) {
                x++;
            } else {
                y--;
            }
        }

        return ret;
    }
}