package medium;

// https://leetcode-cn.com/problems/beautiful-arrangement/
// 526. 优美的排列
public class lc526 {
    private int ret;

    public int countArrangement(int n) {
        ret = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;
            backtrace(i, 1, n, visited);
            visited[i] = false;
        }
        return ret;
    }

    private void backtrace(int current, int index, int n, boolean[] visited) {
        if (index > n) {
            return;
        }
        if ((current % index == 0 || index % current == 0)) {
            if (index == n) {
                ret++;
                return;
            }
        }
        else {
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            backtrace(i, index + 1, n, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        lc526 instance = new lc526();
        System.out.println(instance.countArrangement(12));
    }
}
