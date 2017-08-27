package easy;

/**
 * Author:maslke
 * Date:2017/8/28
 * Version:0.0.1
 * 292. Nim Game
 */
public class lc292 {
    public boolean canWinNim(int n) {
        int m = n % 4;
        return m == 1 || m == 2 || m == 3;
    }
}
