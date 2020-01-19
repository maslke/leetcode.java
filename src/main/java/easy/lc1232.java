package easy;

class lc1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;
        int[] a = coordinates[0];
        int[] b = coordinates[1];
        for (int i = 2; i < coordinates.length; i++) {
            int m = (coordinates[i][1] - a[1]) * (b[0] - a[0]);
            int n = (b[1] - a[1]) * (coordinates[i][0] - a[0]);
            if (m != n) return false;
        }
        return true;
    }
}