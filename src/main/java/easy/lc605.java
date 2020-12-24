package easy;

// https://leetcode.com/problems/can-place-flowers/
// 605. Can Place Flowers

class lc605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        if(n == 0) {
            return true;
        }
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1) {
                i = i + 2;
            } else {
                if (i == flowerbed.length - 1) {
                    n--;
                    break;
                }
                if (flowerbed[i + 1] == 0) {
                    n--;
                    if (n <= 0) {
                        return true;
                    }
                    i = i + 2;
                } else {
                    i = i + 3;
                }
            }
        }
        return n <= 0;
    }
    
   
}
