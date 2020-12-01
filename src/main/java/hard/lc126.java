package hard;

import java.util.*;

// https://leetcode-cn.com/problems/word-ladder-ii/
// 单词接龙 II

public class lc126 {
    class Wrapper {
        String word;
        int inx;

        Wrapper(String word, int inx) {
            this.word = word;
            this.inx = inx;
        }
    }

    private int inx = 0;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ret;
        }
        ret = bfs(beginWord, endWord, wordList);
        return ret;
    }

    private boolean isvalid(String begin, String end) {
        if (begin.equals(end)) {
            return false;
        }
        char[] c1 = begin.toCharArray();
        char[] c2 = end.toCharArray();
        int diff = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }


    private List<List<String>> bfs(String begin, String end, List<String> wordList) {
        Queue<Wrapper> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Map<Wrapper, Wrapper> map = new HashMap<>();
        Wrapper root = new Wrapper(begin, inx++);
        queue.add(root);
        set.add(begin);
        map.put(root, null);
        List<List<String>> ret = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> set2 = new HashSet<>();
            for (int i = 0; i < size; i++) {
                Wrapper wrapper = queue.poll();
                if (wrapper.word.equals(end)) {
                    LinkedList<String> list = new LinkedList<>();
                    Wrapper temp = wrapper;
                    while (temp != null) {
                        list.addFirst(temp.word);
                        temp = map.get(temp);
                    }
                    ret.add(list);
                    continue;
                }

                char[] chars = wrapper.word.toCharArray();
                for (int index = 0; index < chars.length; index++) {
                    char ch = chars[index];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[index] = c;
                        String temp = new String(chars);
                        if (!set.contains(temp) && dict.contains(temp)) {
                            Wrapper w = new Wrapper(temp, inx++);
                            queue.offer(w);
                            map.put(w, wrapper);
                            set2.add(temp);
                        }
                    }
                    chars[index] = ch;
                }
            }
            set.addAll(set2);
            if (!ret.isEmpty()) {
                break;
            }
        }
        return ret;
    }
}
