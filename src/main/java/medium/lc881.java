package medium;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
// 881. Boats to Save People

class lc881 {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (i == j) {
                count++;
                break;
            }
            else {
                if (people[j] + people[i] <= limit) {
                    i++;
                }
                j--;
                count++;
            }
        }
        return count;
    }
}