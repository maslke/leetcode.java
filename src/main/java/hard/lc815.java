package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://leetcode-cn.com/problems/bus-routes/
// 815. 公交路线
public class lc815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int n = routes.length;
        List<Set<Integer>> list = new ArrayList<>();
        for (int[] route : routes) {
            Set<Integer> set = new HashSet<>();
            for (int r : route) {
                set.add(r);
            }
            list.add(set);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int steps = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(source)) {
                queue.offer(i);
                visited[i] = true;
            }
        }


        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int v = queue.poll();
                if (list.get(v).contains(target)) {
                    return steps;
                }

                for (int s : list.get(v)) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).contains(s) && !visited[j]) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }

            }
        }
        return -1;
    }

    // better
    public int numBusesToDestination2(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }


        int n = routes.length;
        int[][] edges = new int[n][n];
        int steps = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> list = map.getOrDefault(routes[i][j], new ArrayList<>());

                for (int s : list) {
                    edges[i][s] = 1;
                    edges[s][i] = 1;
                }


                list.add(i);
                map.put(routes[i][j], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        for (int s : map.get(source)) {
            queue.offer(s);
            visited[s] = true;
        }


        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int v = queue.poll();

                for (int j = 0; j < routes[v].length; j++) {
                    if (routes[v][j] == target) {
                        return steps;
                    }
                }

                for (int j = 0; j < edges[v].length; j++) {
                    if (edges[v][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }

            }
        }
        return -1;
    }
}
