package easy;

// https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
// 1128. 等价多米诺骨牌对的数量

class lc1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] mark = new int[10][10];
        for (int[] dominoe : dominoes) {
            int a = dominoe[0];
            int b = dominoe[1];
            mark[a][b]++;
            if (a != b) {
                mark[b][a]++;
            }
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                if (mark[i][j] > 1) {
                    count += mark[i][j] * (mark[i][j] - 1) / 2;
                }
            }
        }
        return count;
    }
}