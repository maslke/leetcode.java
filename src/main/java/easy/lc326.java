package easy;

/**
 * Author:maslke
 * Date:2017/9/24
 * Version:0.0.1
 * 326. Power of Three
 */
public class lc326 {
    public boolean isPowerOfThree(int n) {
        //incredible
        return n > 0 && Math.pow(3, 19) % n == 0;
    }
}
