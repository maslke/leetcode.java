package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/all-paths-from-source-to-target/
// 797. All Paths From Source to Target
class lc797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int[] begins = graph[0];
        for (int i = 0; i < begins.length; i++) {
            List<Integer> path = new ArrayList<>();
            boolean[] visited = new boolean[graph.length];
            path.add(0);
            visited[0] = true;
            visit(begins[i], visited, graph, path, ret);
        }
        return ret;
    }
    

    private void visit(int begin, boolean[] visited, int[][] graph, List<Integer> path, List<List<Integer>> ret) {
        if (visited[begin]) return;
        visited[begin] = true;
        path.add(begin);
        if (path.get(path.size() - 1) == graph.length - 1) {
            ret.add(new ArrayList<>(path));
            return;
        }
        int[] another = graph[begin];
        for (int i = 0; i < another.length; i++) {
            visit(another[i], visited.clone(), graph, new ArrayList<>(path), ret); 
        }
    }
}