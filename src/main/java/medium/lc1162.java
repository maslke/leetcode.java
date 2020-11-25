package medium;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/as-far-from-land-as-possible/submissions/
// 1162. As Far from Land as Possible
class lc1162 {

    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 0) {
                    queue.offer(new Node(i, j));
                }
            }
        }
        if (queue.isEmpty() || queue.size() == grid.length * grid.length) return -1;
        Node node = null;
        int[] differX= {-1, 1, 0, 0};
        int[] differY = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = differX[i];
                int y = differY[i];
                int newX = node.x + x;
                int newY = node.y + y;
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid.length || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[node.x][node.y] + 1;
                queue.offer(new Node(newX, newY));
            }
        }
        return grid[node.x][node.y] - 1;
    }

    public int maxDistance2(int[][] grid) {
        int[][] flags = new int[grid.length][grid.length];
        int MAX_VALUE = 2000;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    flags[i][j] = MAX_VALUE;
                }
            }
        }
 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    if (i - 1 >= 0) {
                        flags[i][j] = Math.min(flags[i][j], flags[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        flags[i][j] = Math.min(flags[i][j], flags[i][j - 1] + 1);
                    }
                }
            }
        }
 
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid.length - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    if (i + 1 < grid.length) {
                        flags[i][j] = Math.min(flags[i][j], flags[i + 1][j] + 1);
                    }
                    if (j + 1 < grid.length) {
                        flags[i][j] = Math.min(flags[i][j], flags[i][j + 1] + 1);
                    }
                }
            }
        }
 
        int ret = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    ret = Math.max(ret, flags[i][j]);
                }
            }
        }
 
        if (ret == MAX_VALUE) return -1;
        return ret;
     }
    
}



