package easy;

public class lc1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        if (points.length <= 1) {
            return sum;
        }
        int[] before = points[0];
        for (int i = 1; i < points.length; i++) {
            int diff1 = Math.abs(points[i][0] - before[0]);
            int diff2 = Math.abs(points[i][1] - before[1]);
            sum += (Math.min(diff1 ,diff2) + Math.abs(diff1 - diff2));
            before = points[i];
        }
        return sum;
    }
}
