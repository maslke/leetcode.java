package easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-word-in-dictionary/
// 720. Longest Word in Dictionary

class lc720 {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        int maxLength = 0;
        String result = null;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean ret = true;
            for (int j = 1; j < word.length(); j++) {
                if (!set.contains(word.substring(0, j))) {
                    ret = false;
                    break;
                }
            }
            if (ret && (maxLength < word.length() || (maxLength == word.length() && word.compareTo(result) < 0))) {
                maxLength = word.length();
                result = word;
            }
        }
        return result;
    }
}