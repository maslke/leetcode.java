package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

// https://leetcode.com/problems/all-paths-from-source-to-target/
// 797. All Paths From Source to Target
class lc797 {

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        int n = graph.length;
        if (n == 0) {
            return new ArrayList<List<Integer>>();
        }
        int begin = 0;
        int end = n - 1;
        boolean[][] visited = new boolean[n][n];

        List<List<Integer>> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(begin);
        Set<Integer> set = new HashSet<>();
        set.add(begin);
        while (!stack.isEmpty()) {
            int top = stack.peek();
            if (top == end) {
                List<Integer> path = new ArrayList<>(stack);
                ret.add(path);
                stack.pop();
            } else {
                boolean left = false;
                for (int i = 0; i < graph[top].length; i++) {
                    if (!set.contains(graph[top][i]) && !visited[top][graph[top][i]]) {
                        left = true;
                        stack.push(graph[top][i]);
                        visited[top][graph[top][i]] = true;
                        break;
                    }
                }

                if (!left) {
                    stack.pop();
                    set.remove(top);
                    for (int i = 0; i < graph.length; i++) {
                        visited[top][i] = false;
                    }
                }
            }
        }

        return ret;
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> path = new ArrayList<>();
            boolean[] visited = new boolean[graph.length];
            path.add(0);
            visited[0] = true;
            dfs(graph[0][i], visited, graph, path, ret);
        }
        return ret;
    }
    

    private void dfs(int begin, boolean[] visited, int[][] graph, List<Integer> path, List<List<Integer>> ret) {
        if (visited[begin]) {
            return;
        }
        visited[begin] = true;
        path.add(begin);
        if (begin == graph.length - 1) {
            ret.add(new ArrayList<>(path));
            return;
        }
        int[] another = graph[begin];
        for (int i = 0; i < another.length; i++) {
            if (visited[another[i]]) {
                continue;
            }
            dfs(another[i], visited.clone(), graph, new ArrayList<>(path), ret);
        }
    }
}