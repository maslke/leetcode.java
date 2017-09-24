package easy;

/**
 * Author:maslke
 * Date:2017/9/25
 * Version:0.0.1
 * 605. Can Place Flowers
 */
public class lc605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int i = 0;
        while (i < length) {
            if (n == 0) {
                return true;
            }
            if (flowerbed[i] == 1) {
                i = i + 2;
                continue;
            }
            if (i + 1 < length) {
                if (flowerbed[i + 1] == 1) {
                    i = i + 3;
                } else {
                    n--;
                    i = i + 2;
                }
            } else {
                n--;
                i = i + 2;
            }
        }
        return n == 0;
    }
}
