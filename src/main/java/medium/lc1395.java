package medium;

// https://leetcode.com/problems/count-number-of-teams/
// 1395. Count Number of Teams


class lc1395 {
    public int numTeams(int[] rating) {
        int ret = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int ls = 0;
            int rs = 0;
            int lb = 0;
            int rb = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    ls++;
                } else {
                    lb++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) {
                    rs++;
                } else {
                    rb++;
                }
            }

            ret += ls * rb + lb * rs;
        }    
        return ret;
    }

}