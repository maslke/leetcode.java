package easy;

public class lc1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] values = new int[101];
        for (int num : nums) {
            values[num]++;
        }
        int count = 0;
        for (int v : values) {
            count += cnt(v);
        }
        return count;
    }

    private int cnt(int count) {
        if (count == 0) {
            return 0;
        }
        return count * (count - 1) / 2;
    }
}
