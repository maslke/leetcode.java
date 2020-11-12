package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int[] degress = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            list.get(b).add(a);
            degress[a]++;
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < degress.length; i++) {
            if (degress[i] == 0) {
                stack.push(i);
            }
        }

        int inx = 0;
        int[] ret = new int[numCourses];
        while (!stack.isEmpty()) {
            int top = stack.pop();
            ret[inx++] = top;
            List<Integer> edges = list.get(top);
            for (int edge : edges) {
                degress[edge]--;
                if (degress[edge] == 0) {
                    stack.push(edge);
                }
            }
        }

        return inx == numCourses ? ret: new int[0];
    }
}
