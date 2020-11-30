package hard;

import java.util.*;

// https://leetcode-cn.com/problems/word-break-ii/
// 140. 单词拆分II

public class lc140 {
    List<String> ret = new ArrayList<>();
    Map<Integer, List<List<String>>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> breaks = dfs(s, 0, new HashSet<>(wordDict));
        for (List<String> bk : breaks) {
            ret.add(String.join(" ", bk));
        }
        return ret;

    }

    private List<List<String>> dfs(String s, int inx, Set<String> wordDict) {
        if (map.containsKey(inx)) {
            return map.get(inx);
        }
        List<List<String>> breaks = new LinkedList<>();
        if (inx < s.length()) {
            for (int i = inx + 1; i <= s.length(); i++) {
                String w = s.substring(inx, i);
                if (wordDict.contains(w)) {
                    List<List<String>> ret = dfs(s, i, wordDict);
                    for (List<String> r : ret) {
                        List<String> newR = new LinkedList<>(r);
                        newR.add(0, w);
                        breaks.add(newR);
                    }
                }
            }
        } else {
            breaks.add(new LinkedList<>());
        }

        map.put(inx, breaks);

        return map.get(inx);
    }


//    List<String> ret = new ArrayList<>();
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        dfs(s, wordDict, new ArrayList<>());
//        return ret;
//
//    }
//
//    // 超时了
//    private void dfs(String current, List<String> wordDict, List<String> list) {
//        if (current.length() == 0) {
//            ret.add(String.join(" ", list));
//            return;
//        }
//        for (int i = 0; i < wordDict.size(); i++) {
//            String word = wordDict.get(i);
//            if (current.indexOf(word) == 0) {
//                list.add(word);
//                dfs(current.substring(word.length()), wordDict, list);
//                list.remove(list.size() - 1);
//            }
//        }
//    }
}
