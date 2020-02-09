package easy;
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
// 1342. Number of Steps to Reduce a Number to Zero
class lc1342 {
    public int numberOfSteps (int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }
}