package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class lc17_22 {
    private void dfs(String begin, String end, List<String> paths, Set<String> dict, Set<String> set, List<String> result) {
        if (!result.isEmpty()) {
            return;
        }
        if (begin.equals(end)) {
            result.addAll(paths);
        }
        else {
            for (String temp : dict) {
                if (valid(begin, temp) && dict.contains(temp) && !set.contains(temp)) {
                    paths.add(temp);
                    int size = paths.size();
                    set.add(temp);
                    dfs(temp, end, paths, dict, set, result);
                    paths.remove(size - 1);
                    set.remove(temp);
                }
            }
        }
    }

    private boolean valid(String word, String d) {
        int length = word.length();
        int diff = 0;
        if (d.length() != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (d.charAt(i) != word.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> paths = new ArrayList<>();
        Set<String> set = new HashSet<>();
        paths.add(beginWord);
        set.add(beginWord);
        List<String> result = new ArrayList<>();
        dfs(beginWord, endWord, paths, new HashSet<>(wordList), set, result);
        return result;
    }

    public static void main(String[] args) {
        lc17_22 instance = new lc17_22();
        String begin = "hit";
        String end = "cog";
        List<String> dict = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<String> ret = instance.findLadders(begin, end, dict);
    }

    // dfs
    public List<String> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<String> ret = new ArrayList<>();
        // stack
        Stack<String> stack = new Stack<>();
        stack.push(beginWord);
        // dict
        Set<String> dict = new HashSet<>(wordList);
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        while (!stack.isEmpty()) {
            String peek = stack.peek();
            if (!map.containsKey(peek)) {
                map.put(peek, new HashSet<>());
            }
            map.get(peek).add(peek);
            if (peek.equals(endWord)) {
                ret.addAll(stack);
                break;
            }
            else {
                boolean placed = false;
                char[] chars = peek.toCharArray();
                for (int i = 0; i < peek.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chars[i];
                        chars[i] = c;
                        String temp = new String(chars);
                        if (dict.contains(temp) && !set.contains(temp) && !map.get(peek).contains(temp)) {
                            stack.push(temp);
                            set.add(temp);
                            map.get(peek).add(temp);
                            placed = true;
                            break;
                        }
                        else {
                            chars[i] = old;
                        }
                    }
                    if (placed) {
                        break;
                    }
                }
                if (!placed) {
                    stack.pop();
                    set.remove(peek);
                    map.get(peek).clear();
                }
            }
        }
        return ret;
    }
}
