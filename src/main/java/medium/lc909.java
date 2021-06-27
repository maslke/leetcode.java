package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode-cn.com/problems/snakes-and-ladders/
// 909. 蛇梯棋
public class lc909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[n * n + 1];
        if (board[0][0] == -1) {
            queue.offer(1);
            visited[1] = true;
        } else {
            queue.offer(board[0][0]);
            visited[board[0][0]] = true;
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int value = queue.poll();
                if (value == n * n) {
                    return steps - 1;
                }
                for (int j = 1; j <= 6; j++) {
                    int m = value + j;

                    if (m > n * n) {
                        break;
                    }

                    int x = (m - 1) / n;
                    int y = (m - 1) % n;

                    if (x % 2 == 1) {
                        y = n - 1 - y;
                    }
                    x = n - 1 - x;

                    if (board[x][y] != -1) {
                        m = board[x][y];
                    }

                    if (!visited[m]) {
                        queue.offer(m);
                        visited[m] = true;
                    }
                }

            }
        }

        return -1;
    }
}
