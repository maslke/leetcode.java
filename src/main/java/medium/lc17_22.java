package medium;

import java.util.*;

public class lc17_22 {

    private Set<String> visited = new HashSet<>();

    private void dfs(String begin, String end, List<String> paths, List<String> dict, Set<String> set, List<String> result) {
        if (!result.isEmpty()) {
            return;
        }
        if (begin.equals(end)) {
            result.addAll(paths);
        } else {
            for (String temp : dict) {
                if (!result.isEmpty()) {
                    return;
                }
                if (!visited.contains(temp) && !set.contains(temp) && valid(begin, temp)) {
                    paths.add(temp);
                    int size = paths.size();
                    set.add(temp);
                    dfs(temp, end, paths, dict, set, result);
                    paths.remove(size - 1);
                    set.remove(temp);
                    visited.add(temp);
                }
            }
        }
    }

    private boolean valid(String word, String d) {
        int length = word.length();
        int diff = 0;
        if (d.length() != length || word.equals(d)) {
            return false;
        }
        char[] c1 = word.toCharArray();
        char[] c2 = d.toCharArray();
        for (int i = 0; i < length; i++) {
            if (c1[i] != c2[i]) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> paths = new ArrayList<>();
        Set<String> set = new HashSet<>();
        paths.add(beginWord);
        set.add(beginWord);
        List<String> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }
        dfs(beginWord, endWord, paths, wordList, set, result);
        return result;
    }

    // dfs
    public List<String> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<String> ret = new ArrayList<>();
        // stack
        Stack<String> stack = new Stack<>();
        stack.push(beginWord);
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            String peek = stack.peek();
            if (!map.containsKey(peek)) {
                map.put(peek, new HashSet<>());
            }
            map.get(peek).add(peek);
            if (peek.equals(endWord)) {
                ret.addAll(stack);
                break;
            } else {
                boolean placed = false;
                for (String temp : wordList) {
                    if (!visited.contains(temp) && !set.contains(temp) && !map.get(peek).contains(temp) && valid(temp, peek)) {
                        stack.push(temp);
                        set.add(temp);
                        map.get(peek).add(temp);
                        visited.add(temp);
                        placed = true;
                        break;
                    }
                }
                if (!placed) {
                    stack.pop();
                    map.get(peek).clear();
                }
            }
        }
        return ret;
    }
}
