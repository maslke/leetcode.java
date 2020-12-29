package easy;

// https://leetcode-cn.com/problems/determine-if-string-halves-are-alike/
// 1794. 判断字符串的两半是否相似

public class lc1704 {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int len = s.length();
        boolean[] flag = new boolean[1000];
        flag['a'] = true;
        flag['A']= true;
        flag['E'] = true;
        flag['e'] = true;
        flag['i'] = true;
        flag['I'] = true;
        flag['O'] = true;
        flag['o'] = true;
        flag['u'] = true;
        flag['U'] = true;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (flag[c]) {
                if (i >=  len / 2) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        return count == 0;
    }
}
