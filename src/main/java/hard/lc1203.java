package hard;

import java.util.*;

// https://leetcode-cn.com/problems/sort-items-by-groups-respecting-dependencies/
// 1203. 项目管理

public class lc1203 {
    private List<Integer> topoSort(List<Integer>[] graph, int[] indegrees) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int p = queue.poll();
            result.add(p);
            List<Integer> items = graph[p];

            for (int item : items) {
                indegrees[item]--;
                if (indegrees[item] == 0) {
                    queue.offer(item);
                }
            }
        }
        if (result.size() == indegrees.length) {
            return result;
        }
        return new ArrayList<>();
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        List<Integer>[] groupsGraph = new List[m];
        List<Integer>[] itemsGraph = new List[n];
        for (int i = 0; i < m; i++) {
            groupsGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            itemsGraph[i] = new ArrayList<>();
        }

        int[] groupIndegrees = new int[m];
        for (int i = 0; i < group.length; i++) {
            int currentGroup = group[i];
            for (int item : beforeItems.get(i)) {
                if (group[item] != currentGroup) {
                    groupsGraph[group[item]].add(currentGroup);
                    groupIndegrees[currentGroup]++;
                }
            }

        }
        int[] itemIndegrees = new int[n];
        for (int i = 0; i < itemsGraph.length; i++) {
            List<Integer> items = beforeItems.get(i);
            for (int item : items) {
                itemsGraph[item].add(i);
                itemIndegrees[i]++;
            }
        }

        List<Integer> topoGroup = topoSort(groupsGraph, groupIndegrees);
        if (topoGroup.isEmpty()) {
            return new int[0];
        }
        List<Integer> topoItem = topoSort(itemsGraph, itemIndegrees);
        if (topoItem.isEmpty()) {
            return new int[0];
        }


        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int current = topoItem.get(i);
            List<Integer> list = map.getOrDefault(group[current], new ArrayList<>());
            list.add(current);
            map.put(group[current], list);
        }

        List<Integer> result = new ArrayList<>();
        for (Integer integer : topoGroup) {
            List<Integer> list = map.getOrDefault(integer, new ArrayList<>());
            result.addAll(list);
        }


        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
