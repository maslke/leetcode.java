package medium;

// https://leetcode-cn.com/problems/car-pooling/
// 1094. 拼车

public class lc1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] people = new int[1001];
        for (int[] trip : trips) {
            people[trip[1]] += trip[0];
            people[trip[2]] -= trip[0];
        }

        int sum = people[0];
        if (sum > capacity) {
            return false;
        }
        for (int i = 1; i < people.length; i++) {
            sum += people[i];
            if (sum > capacity) {
                return false;
            }
        }

        return true;
    }
}
