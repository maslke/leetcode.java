package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/iterator-for-combination/
// 1286. 字母组合迭代器

public class CombinationIterator {
    private List<String> combinations;
    private int inx;
    public CombinationIterator(String characters, int combinationLength) {
        this.combinations = new ArrayList<>();
        this.inx = 0;
        backtrace(characters.toCharArray(), 0, combinationLength, new StringBuilder(), 0);
    }

    private void backtrace(char[] chars, int position, int length, StringBuilder sb, int inx) {
        if (position == length) {
            this.combinations.add(sb.toString());
            return;
        }
        for (int i = inx; i < chars.length; i++) {
            sb.append(chars[i]);
            backtrace(chars, position + 1, length, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String next() {
        return this.combinations.get(this.inx++);
    }

    public boolean hasNext() {
        return this.inx < this.combinations.size();
    }

}
