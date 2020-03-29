package medium;

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

    private int[][] flags;
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
    
}



