package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc406 {

    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[0][0]);
    }


    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            else {
                return a[0] - b[0];
            }
        });

        int[][] ret = new int[people.length][2];
        for (int i = 0; i < ret.length; i++) {
            ret[i][0] = -1;
        }
        for (int[] person : people) {
            int count = 0;
            int j = 0;
            while (j < people.length && count < person[1]) {
                if (ret[j][0] == -1 || ret[j][0] >= person[0]) {
                    count++;
                }
                j++;
            }
            while (j < people.length) {
                if (ret[j][0] == -1) {
                    break;
                }
                j++;
            }
            ret[j] = person;
        }
        return ret;
    }
}
