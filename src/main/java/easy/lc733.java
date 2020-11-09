package easy;

// https://leetcode-cn.com/problems/flood-fill/
// 733. 图像渲染

public class lc733 {
    boolean[][] visited;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }
        if (visited[sr][sc]) {
            return;
        }
        visited[sr][sc] = true;
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            dfs(image, sr + 1, sc, oldColor, newColor);
            dfs(image, sr - 1, sc, oldColor, newColor);
            dfs(image, sr, sc + 1, oldColor, newColor);
            dfs(image, sr, sc - 1, oldColor, newColor);
        }
    }
}
