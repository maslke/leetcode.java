package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/eight-queens-lcci/
// 面试题 08.12. 八皇后

public class lc0812 {


    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] stacked = new boolean[n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            stack.push(i);
            Arrays.fill(stacked, false);
            stacked[i] = true;
            for (int inx = 0; inx < n; inx++) {
                Arrays.fill(visited[inx], false);
            }
            while (!stack.isEmpty()) {
                int arr = stack.peek();
                int size = stack.size();
                if (size == n) {
                    List<String> path = new ArrayList<>();

                    for (int value : stack) {
                        char[] chars = new char[n];
                        Arrays.fill(chars, '.');
                        chars[value] = 'Q';
                        path.add(new String(chars));
                    }
                    ret.add(path);

                    stack.pop();
                    stacked[arr] = false;
                    Arrays.fill(visited[size - 1], false);
                }
                else {
                    boolean placed = false;
                    for (int j = 0; j < n; j++) {
                        if (!stacked[j] && !visited[size - 1][j] && valid(stack, j)) {
                            stack.push(j);
                            stacked[j] = true;
                            placed = true;
                            visited[size - 1][j] = true;
                            break;
                        }
                    }

                    if (!placed) {
                        stack.pop();
                        stacked[arr] = false;
                        Arrays.fill(visited[size - 1], false);
                    }

                }
            }
        }

        return ret;
    }

    private boolean valid(Stack<Integer> stack, int column) {
        if (stack.isEmpty()) {
            return true;
        }
        int size = stack.size();
        for (int i = 0; i < stack.size(); i++) {
            if (Math.abs(size - i) == Math.abs(column - stack.get(i))) {
                return false;
            }
        }
        return true;
    }

}
