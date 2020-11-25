package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class lc127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Set<String> set2 = new HashSet<>();
        set2.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int min = Integer.MAX_VALUE;
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int inx = 0; inx < size; inx++) {
                String w = queue.poll();
                if (w.equals(endWord)) {
                    return level;
                }
                for (int i = 0; i < beginWord.length(); i++) {
                    for (char chr = 'a'; chr <= 'z'; chr++) {
                        String temp;
                        char[] chars = w.toCharArray();
                        chars[i] = chr;
                        temp = new String(chars);

                        if (!set2.contains(temp) && set.contains(temp)) {
                            set2.add(temp);
                            queue.offer(temp);
                        }
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        lc127 ladder = new lc127();
        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
        int result = ladder.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
