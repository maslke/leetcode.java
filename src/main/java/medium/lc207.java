package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/course-schedule/
// 207. 课程表

public class lc207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < degress.length; i++) {
            if (degress[i] == 0) {
                stack.push(i);
            }
        }

        int count = 0;
        while (!stack.isEmpty()) {
            int top = stack.pop();
            count++;
            List<Integer> edges = list.get(top);
            for (int edge : edges) {
                degress[edge]--;
                if (degress[edge] == 0) {
                    stack.push(edge);
                }
            }
        }

        return count == numCourses;
    }
}
