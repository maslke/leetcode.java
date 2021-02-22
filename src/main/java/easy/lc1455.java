package easy;

// https://leetcode-cn.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
// 1455. 检查单词是否为句中其他单词的前缀

public class lc1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] parts = sentence.split(" ");
        int i = 0;
        for (; i < parts.length; i++) {
            if (parts[i].indexOf(searchWord) == 0) {
                break;
            }
        }
        if (i == parts.length) {
            return -1;
        }
        return i + 1;
    }
}
