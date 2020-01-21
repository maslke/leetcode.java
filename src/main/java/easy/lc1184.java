package easy;

class lc1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int v1 = 0;
        int v2 = 0;
        int s = Math.min(start, destination);
        int d = Math.max(start, destination);
        for (int i = s; i < d; i++) {
            v1 += distance[i];
        }
        for (int i = d; i < distance.length; i++) {
            v2 += distance[i];
        }
        for (int i = 0; i < s; i++) {
            v2 += distance[i];
        }
        return Math.min(v1, v2);
    }
}