package easy;

// https://leetcode-cn.com/problems/baby-names-lcci/
// 面试题 17.07. 婴儿名字

import java.util.*;

public class lc17_07 {

    static class Pair {
        String name;
        int val;
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        List<String> ret = new ArrayList<>();
        Map<String, Integer> map  = new HashMap<>();
        Set<String> allNames = new HashSet<>();
        for (String name : names) {
            int inx = name.indexOf("(");
            allNames.add(name.substring(0, inx));
            map.put(name.substring(0, inx), Integer.parseInt(name.substring(inx + 1, name.length() - 1)));
        }
        Map<String, List<String>> graph = new HashMap<>();
        for (String name : synonyms) {
            String[] parts = name.substring(1, name.length() - 1).split(",");
            String one = parts[0];
            String other = parts[1];
            List<String> list = graph.getOrDefault(one, new ArrayList<>());
            list.add(other);
            graph.put(one, list);

            list = graph.getOrDefault(other, new ArrayList<>());
            list.add(one);
            graph.put(other, list);
        }

        Set<String> visited = new HashSet<>();
        Pair pair = new Pair();
        for (String name : allNames) {
            if (visited.contains(name)) {
                continue;
            }
            pair.name = name;
            int val = dfs(name, visited, graph, map, pair);
            ret.add(pair.name + "(" + val +")");
        }

        return ret.toArray(new String[0]);
    }

    private int dfs(String name, Set<String> set, Map<String, List<String>> graph, Map<String, Integer> map, Pair pair) {
        if (set.contains(name)) {
            return 0;
        }
        set.add(name);
        if (pair.name.compareTo(name) > 0) {
            pair.name = name;
        }
        int val = map.getOrDefault(name, 0);
        if (graph.containsKey(name)) {
            List<String> names = graph.get(name);
            for (String n : names) {
                val += dfs(n, set, graph, map, pair);
            }
        }
        return val;
    }
}
