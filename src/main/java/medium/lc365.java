package medium;

// https://leetcode.com/problems/water-and-jug-problem/
// 365. Water and Jug Problem

class lc365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        if (x + y < z) return false;
        if (x == 0) return y == z;
        if (y == 0) return x == z;
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        return z % gcd(max, min) == 0;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    } 
}