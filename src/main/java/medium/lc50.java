package medium;

// https://leetcode-cn.com/problems/powx-n/
// 50. Pow(x, n)

class Solution {

    public double myPow(double x, int n) { 
        long n1 = n;
        if (n1 < 0) {
            n1 = -n1;
            x = 1.0 / x;
        }
        return pow(x, n1);
        
    }

    private double pow(double x, long n) {
        if (n == 0) return 1.0;
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
       
        
    }
}