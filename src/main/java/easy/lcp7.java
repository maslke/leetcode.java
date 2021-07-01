package easy;

import java.util.LinkedList;

public class lcp7 {
    int count = 0;
    public int numWays(int n, int[][] relation, int k) {

        LinkedList[] edges = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < relation.length; i++) {
            edges[relation[i][0]].offerLast(relation[i][1]);
        }
        dfs(edges, 0, n - 1, 0, k);
        return count;
    }
    private void dfs(LinkedList[] edges, int start, int target, int depth, int total) {
        if (depth == total) {
            if (start == target) {
                count++;
            }
            return;
        }
        for (int v : (LinkedList<Integer>) edges[start]) {
            dfs(edges, v, target, depth + 1, total);
        }
    }
}
