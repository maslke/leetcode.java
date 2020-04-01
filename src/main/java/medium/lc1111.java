package medium;

// https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
// 1111. 有效括号的嵌套深度

class lc1111 {
    public int[] maxDepthAfterSplit(String seq) {
        char[] chars = seq.toCharArray();
        int inx = 0;
        int[] ret = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                inx++;
                ret[i] = inx % 2;

            } else {
                ret[i] = inx % 2;
                inx--;
            }
            
        }
        return ret;
    }
}