package easy;

// https://leetcode-cn.com/problems/lemonade-change/
// 860. 柠檬水找零

public class lc860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                ten++;
                five--;
            } else {
                if (ten == 0) {
                    if (five < 3) {
                        return false;
                    }
                    five = five - 3;
                } else {
                    ten--;
                    if (five == 0) {
                        return false;
                    }
                    five--;
                }
            }
        }
        return true;
    }
}
