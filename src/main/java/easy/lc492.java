package easy;

/**
 * Author:maslke
 * Date:2017/9/1
 * Version:0.0.1
 * 492. Construct the Rectangle
 */
public class lc492 {
    public int[] constructRectangle(int area) {
        int[] ret = new int[2];
        int maxWidth = (int)Math.sqrt(area);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= maxWidth; i++) {
            if (area % i == 0 && min > Math.abs(i - area / i)) {
                ret[0] = area / i;
                ret[1] = i;
                min = Math.abs(i - area/ i);
            }
        }
        return ret;
    }
}
