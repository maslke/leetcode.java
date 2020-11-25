package easy;

// https://leetcode-cn.com/problems/distribute-candies-to-people/
// 1103. 分糖果II

class lc1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ret = new int[num_people];
        int start = 1;
        int inx = 0;
        while (candies > 0) {
            int value = start <= candies ? start : candies;
            ret[inx % num_people] += value;
            candies = candies - start;
            start++;
            inx++;
        }
        return ret;
    }
}