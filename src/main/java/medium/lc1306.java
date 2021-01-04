package medium;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/jump-game-iii/
// 130. 跳跃游戏III
public class lc1306 {

    public boolean canReach2(int[] arr, int start) {
        return dfs(arr, start, new boolean[arr.length]);
    }

    private boolean dfs(int[] arr, int start, boolean[] visited) {
        if (start < 0 || start >= arr.length || visited[start]) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        visited[start] = true;
        return dfs(arr, start + arr[start], visited) || dfs(arr, start - arr[start], visited);
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int inx =  queue.poll();
                if (arr[inx] == 0) {
                    return true;
                }
                int a = inx + arr[inx];
                if (a < arr.length && !visited[a]) {
                    visited[a] = true;
                    queue.offer(a);
                }
                int b =inx -arr[inx];
                if (b >= 0 && !visited[b]) {
                    visited[b] = true;
                    queue.offer(b);
                }
            }
        }
        return false;
    }
}
