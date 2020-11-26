package medium;

import java.util.*;

// https://leetcode-cn.com/problems/accounts-merge/
// 721. 账户合并

public class lc721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> emails = new HashSet<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                map.put(account.get(i), account.get(0));
                String email = account.get(i);
                emails.add(email);
                Set<String> set = graph.getOrDefault(email, new HashSet<>());
                for (int j = 1; j < account.size(); j++) {
                    if (j != i)  {
                        set.add(account.get(j));
                    }
                }
                graph.put(email, set);
            }
        }

        Set<String> visited = new HashSet<>();
        for (String email : emails) {
            if (visited.contains(email)) {
                continue;
            }
            List<String> paths = new ArrayList<>();
            dfs(email, graph, visited, paths);
            Collections.sort(paths);
            paths.add(0, map.get(paths.get(0)));
        }

        return ret;
    }

    private void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> paths) {
        if (visited.contains(email)) {
            return;
        }
        paths.add(email);
        visited.add(email);
        if (graph.containsKey(email)) {
            Set<String> emails = graph.get(email);
            for (String e : emails) {
                dfs(e, graph, visited, paths);
            }
        }
    }
}
