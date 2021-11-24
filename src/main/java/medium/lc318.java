package medium;

// https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
// 318. 最大单词长度乘积

public class lc318 {
    public int maxProduct(String[] words) {
        int[] a = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int diff = words[i].charAt(j) - 'a';
                a[i] = a[i] | (1 << diff);
            }
        }
        int ret = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((a[i] & a[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }

}
