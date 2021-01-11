package medium;

import java.util.*;

public class lc1202 {

    int[] v;
    int[] sz;

    private int find(int p) {

        while (v[p] != p) {
            p = v[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            v[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            v[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    public String smallestStringWithSwaps2(String s, List<List<Integer>> pairs) {
        int len = s.length();
        v = new int[len];
        for (int i = 0; i < len; i++) {
            v[i] = i;
        }
        sz = new int[len];
        Arrays.fill(sz, 1);

        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }


        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < v.length; i++) {
            int m = find(i);
            TreeSet<Integer> set = map.getOrDefault(m, new TreeSet<>());
            set.add(i);
            map.put(m, set);
        }

        List<TreeSet<Integer>> list = new ArrayList<>(map.values());

        char[] chars = new char[len];
        for (TreeSet<Integer> set : list) {

            List<Character> lst = new ArrayList<>();
            for (int inx : set) {
                lst.add(s.charAt(inx));
            }
            Collections.sort(lst);
            int index = 0;

            for (int inx : set) {
                chars[inx] = lst.get(index++);
            }

        }
        return new String(chars);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        int[][] grid = new int[len][len];
        for (List<Integer> pair : pairs) {
            int a = pair.get(0);
            int b = pair.get(1);
            grid[a][b] = 1;
            grid[b][a] = 1;
        }

        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (visited.contains(i)) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            dfs(grid, i, visited, set);
            list.add(set);
        }

        char[] chars = new char[len];
        for (Set<Integer> set : list) {

            List<Character> lst = new ArrayList<>();
            for (int inx : set) {
                lst.add(s.charAt(inx));
            }
            Collections.sort(lst);
            int index = 0;

            List<Integer> lst2 = new ArrayList<>(set);
            Collections.sort(lst2);

            for (int inx : lst2) {
                chars[inx] = lst.get(index++);
            }

        }
        return new String(chars);


    }

    private void dfs(int[][] grid, int start, Set<Integer> visited, Set<Integer> group) {
        int[] values = grid[start];
        visited.add(start);
        group.add(start);
        for (int i = 0; i < values.length; i++) {
            if (visited.contains(i) || values[i] == 0) {
                continue;
            }
            dfs(grid, i, visited, group);
        }
    }

    public static void main(String[] args) {
        lc1202 instance = new lc1202();
        // [[0,3],[1,2],[0,2]]
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        pairs.add(Arrays.asList(0, 2));
        instance.smallestStringWithSwaps2("dcab", pairs);

    }
}
