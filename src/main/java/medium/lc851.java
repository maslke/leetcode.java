package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/loud-and-rich/
// 851. 喧闹和富有
public class lc851 {


    public int[] loudAndRich2(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] inDegres = new int[n];
        int[][] edges = new int[n][n];
        for (int i = 0; i < richer.length; i++) {
            int a = richer[i][0];
            int b = richer[i][1];
            edges[a][b] = 1;
            inDegres[b]++;
        }

        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = i;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegres[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int[] edge = edges[node];

            for (int i = 0; i < n; i++) {
                if (edge[i] == 0) {
                    continue;
                }
                if (quiet[ret[node]] < quiet[ret[i]]) {
                    ret[i] = ret[node];
                }
                inDegres[i]--;
                if (inDegres[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return ret;

    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[][] edges = new int[n][n];
        for (int i = 0; i < richer.length; i++) {
            int a = richer[i][0];
            int b = richer[i][1];

            edges[b][a] = 1;
        }

        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        for (int i = 0; i < n; i++) {
            dfs(edges, i, quiet, ret);
        }
        return ret;
    }

    private void dfs(int[][] edges, int start, int[] quiet, int[] ret) {
        if (ret[start] != -1) {
            return;
        }
        ret[start] = start;
        int[] edge = edges[start];
        for (int i = 0; i < edge.length; i++) {
            if (edge[i] == 1) {
                dfs(edges, i, quiet, ret);
                if (quiet[ret[i]] < quiet[ret[start]]) {
                    ret[start] = ret[i];
                }
            }
        }
    }
}
