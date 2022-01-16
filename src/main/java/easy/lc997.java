package easy;

// https://leetcode.com/problems/find-the-town-judge/
// 997. Find the Town

class lc997 {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        int[] fre = new int[n + 1];
        int[] set = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            set[a] = 1;
            fre[b]++;
        }
        for (int i = 1; i < fre.length; i++) {
            if (fre[i] == n - 1 && set[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}