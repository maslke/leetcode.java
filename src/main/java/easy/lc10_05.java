package easy;

// https://leetcode-cn.com/problems/sparse-array-search-lcci/
// 面试题 10.05. 稀疏矩阵搜索

public class lc10_05 {

    public int findString2(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (words[middle].equals("") && !words[left].equals(s)) {
                left++;
                continue;
            } else if (words[left].equals(s)) {
                return left;
            }
            String target = words[middle];
            int ret = target.compareTo(s);
            if (ret == 0) {
                return middle;
            } else if (ret > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }
        return -1;
    }

    public int findString(String[] words, String s) {
        return search(words, 0, words.length - 1, s);
    }

    private int search(String[] words, int left, int right, String s) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        String target = words[middle];
        if (target.equals("")) {
            int ret = search(words, left, middle - 1, s);
            if (ret != -1) {
                return ret;
            }
            return search(words, middle + 1, right, s);
        } else {
            if (target.equals(s)) {
                return middle;
            } else if (target.compareTo(s) > 0) {
                return search(words, left, middle - 1, s);
            } else {
                return search(words, middle + 1, right, s);
            }
        }
    }
}
