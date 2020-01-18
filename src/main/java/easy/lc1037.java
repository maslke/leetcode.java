package easy;

class lc1037 {
    public boolean isBoomerang(int[][] points) {
        if (same(points[0], points[1]) || same(points[0], points[2]) || same(points[1], points[2])) return false;
        int a = ((points[2][1] - points[0][1]) * (points[1][0] - points[0][0]));
        int b = ((points[1][1] - points[0][1]) * (points[2][0] - points[0][0]));
        return a != b;
    }

    private boolean same(int[] one, int[] another) {
        return one[0] == another[0] && one[1] == another[1];
    }
}