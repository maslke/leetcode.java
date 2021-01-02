package easy;

// https://leetcode-cn.com/problems/count-of-matches-in-tournament/
// 1688. 比赛中的配对次数

public class lc1688 {
    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return n / 2 + numberOfMatches(n / 2);
        } else {
            return (n - 1) / 2 + numberOfMatches((n - 1) / 2 + 1);
        }
    }
}
