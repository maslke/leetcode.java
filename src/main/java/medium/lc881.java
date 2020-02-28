package medium;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
// 881. Boats to Save People
class lc881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (i == j) {
                count++;
                break;
            }
            int m = people[j];
            int n = people[i];
            if (m >= limit) {
                count++;
                j--;
            } else {
                if (m + n <= limit) {
                    count++;
                    j--;
                    i++;
                } else {
                    count++;
                    j--;
                }
            }
        }
        return count;
    }
}