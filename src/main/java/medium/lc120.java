package medium;

import java.util.List;
import java.util.ArrayList;

class lc120 {
    // 2
    // 3 4
    // 6 5 7
    // 4 1 8 3
    // brute force
    // Time Limit Exceeded

    // 2
    // 5 6
    // 11 10 13
    // 15 11 18 16

    //   -1
    // +3  +2
    //-3 +1 -1

    // -1
    // +2 +1
    // 
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) return 0;
        if (triangle.get(0).isEmpty()) return 0;
        int m = triangle.get(0).get(0);
        List<List<Integer>> t1 = new ArrayList<List<Integer>>();
        for (List<Integer> list : triangle) {
            t1.add(new ArrayList<>(list));
        }

        List<List<Integer>> t2 = new ArrayList<List<Integer>>();
        for (List<Integer> list : triangle) {
            t2.add(new ArrayList<>(list));
        }
        t1.remove(0);
        t2.remove(0);

        for (List<Integer> list : t1) {
            t1.remove(list.size() - 1);
        }

        for (List<Integer> list : t2) {
            list.remove(0);
        }

        return m + Math.min(minimumTotal(t1), minimumTotal(t2));
    }

    public int minimumTotal3(List<List<Integer>> t) {
        int lines = t.size();
        for (int i = 1; i < lines; i++) {
            for (int j = 0; j < t.get(i).size(); j++) {
                if (j == 0) {
                    t.get(i).set(j, t.get(i).get(j) + t.get(i - 1).get(j));
                } else (j == t.get(i - 1).size()) {
                    t.get(i).set(j, t.get(i).get(j) + t.get(i - 1).get(j - 1));
                } else {
                    t.get(i).set(j, t.get(i).get(j) + Math.min(t.get(i - 1).get(j), t.get(i - 1).get(j - 1)));
                }
            }
        }

        List<Integer> list = t.get(lines - 1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (min > list.get(i)) {
                min = list.get(i);
            }
        }
        return min;
    }


    public int minimumTotal2(List<List<Integer>> triangle) {
        List<Integer> previous = new ArrayList<>(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            int size = previous.size();
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                if (j - 1 >= 0 && j - 1 < size) {
                    a = previous.get(j - 1);
                }
                if (j < size) {
                    b = previous.get(j);
                }
                row.add(triangle.get(i).get(j) + Math.min(a, b));
            }

            previous.clear();
            previous.addAll(row);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < previous.size(); i++) {
            if (min > previous.get(i)) {
                min = previous.get(i);
            }
        }
        return min;

    }

}