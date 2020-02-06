package easy;

// https://leetcode.com/problems/find-the-town-judge/
// 997. Find the Town Judge

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] ret = new int[N + 1][N + 1];
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            ret[a][b] = 1;
        }
        int judge = -1;
        for (int i = 1; i <= N; i++) {
            boolean zero = true;
            for (int j = 1; j <= N; j++) {
                if (ret[i][j] != 0) {
                    zero = false;
                    break;
                }
            }
            if (zero) {
                boolean one = true;
                for (int m = 1; m <= N; m++) {
                    if (m != i) {
                        if (ret[m][i] == 0) {
                            one = false;
                            break;
                        }
                    }
                }
                if (one) {
                    if (judge != -1) {
                        judge = -1;
                        break;
                    } else {
                        judge = i;
                    }
                }
            }
        }
        return judge;
    }
}