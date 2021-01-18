package medium;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode-cn.com/problems/rearrange-words-in-a-sentence/
// 1451. 重新排列句子中的单词

public class lc1451 {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        words[0] = words[0].toLowerCase();

        Arrays.sort(words, Comparator.comparingInt(String::length));


        char[] chars = words[0].toCharArray();
        chars[0] = (char) (chars[0] - 32);
        words[0] = new String(chars);

        return String.join(" ", words);

    }
}
