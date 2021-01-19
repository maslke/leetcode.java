package medium;

import java.util.*;

// https://leetcode-cn.com/problems/accounts-merge/
// 721. 账户合并

public class lc721 {

    private int index;
    private Map<String, String> nameMap;
    private Map<Integer, String> indexToEmailMap;
    private Map<String, Integer> emailToIndexMap;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        index = 0;
        nameMap = new HashMap<>(); // index -> user name
        indexToEmailMap = new HashMap<>(); // index -> eamil
        emailToIndexMap = new HashMap<>(); // email -> index
        List<List<String>> noEmailNames = new ArrayList<>();
        UnionFind unionFind = new UnionFind(10000);
        for (List<String> account : accounts) {
            int size = account.size();
            if (size == 1) {
                noEmailNames.add(account);
            } else {
                String name = account.get(0);
                String first = account.get(1);
                int p = unionFind.getIndex(first);
                nameMap.put(first, name);
                for (int i = 2; i < size; i++) {
                    int q = unionFind.getIndex(account.get(i));
                    nameMap.put(account.get(i), name);
                    unionFind.union(p, q);
                }
            }
        }

        List<List<String>> res = unionFind.getResult();
        res.addAll(noEmailNames);
        return res;
    }

    private class UnionFind {
        private int[] f;
        private int[] sz;

        UnionFind(int n) {
            this.f = new int[n];
            this.sz = new int[n];

            for (int i = 0; i < n; i++) {
                this.f[i] = i;
                this.sz[i] = 1;
            }
        }

        int find(int x) {
            while (x != f[x]) {
                x = f[x];
            }
            return x;
        }

        int getIndex(String email) {
            if (emailToIndexMap.containsKey(email)) {
                return emailToIndexMap.get(email);
            }
            emailToIndexMap.put(email, index);
            indexToEmailMap.put(index, email);
            index++;
            return index - 1;
        }

        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }

            if (sz[pRoot] < sz[qRoot]) {
                sz[qRoot] += sz[pRoot];
                f[pRoot] = qRoot;
            } else {
                sz[pRoot] += sz[qRoot];
                f[qRoot] = pRoot;
            }
        }

        List<List<String>> getResult() {
            Map<Integer, List<String>> map = new HashMap<>();
            for (int i = 0; i <= index; i++) {
                int p = find(i);
                List<String> list = map.getOrDefault(p, new ArrayList<>());
                list.add(indexToEmailMap.get(i));
                map.put(p, list);
            }

            List<List<String>> res = new ArrayList<>();
            for (List<String> emails: map.values()) {
                List<String> list = new ArrayList<>();
                list.add(nameMap.get(emails.get(0)));
                Collections.sort(emails);
                list.addAll(emails);
                res.add(list);
            }

            return res;
        }
    }


    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
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
