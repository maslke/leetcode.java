package easy;

// https://leetcode.com/problems/can-place-flowers/
// 605. Can Place Flowers

class lc605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int j = flowerbed.length;
        while (i < j) {
            if (n == 0) return true;
            if (flowerbed[i] == 1 
                || (i - 1 >= 0 && flowerbed[i - 1] == 1)
                || (i + 1 < j && flowerbed[i + 1] == 1)) {
                i = i + 1;
            } else {
                n--;
                flowerbed[i] = 1;
                i = i + 2;
            }
        }
        return n <= 0;
    }
    
   
}
