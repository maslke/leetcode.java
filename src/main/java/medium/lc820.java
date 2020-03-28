package medium;

import java.util.Arrays;

// https://leetcode.com/problems/short-encoding-of-words/
// 802. Short Encoding of Words

class lc820 {
    public int minimumLengthEncoding(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            words[i] = reversed(word);
        }
        
        Arrays.sort(words);
        
        int max = 0;
        if (words.length == 1) return words[0].length() + 1;
        int i = 1;
        while (i < words.length) {
            if (!words[i].startsWith(words[i - 1])) {
                max += words[i - 1].length() + 1;
            }
            
            if (i + 1 == words.length) {
                    max += words[i].length() + 1;
                }
                i++;
        }
        return max;
    }
    
    private String reversed(String word) {
        char[] chars = word.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}