package hard;

// https://leetcode-cn.com/problems/scramble-string/
// 87. 扰乱字符串

public class lc87 {
    private String s1;
    private String s2;
    private int[][][] values;

    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        values = new int[length][length][length + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, length);
    }

    private boolean dfs(int i1, int i2, int length) {
        if (values[i1][i2][length] != 0) {
            return values[i1][i2][length] == 1;
        }

        if (this.s1.substring(i1, i1 + length).equals(this.s2.substring(i2, i2 + length))) {
            values[i1][i2][length] = 1;
            return true;
        }

        if (!similar(i1, i2, length)) {
            values[i1][i2][length] = -1;
            return false;
        }

        for (int i = 1; i < length; i++) {
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i)) {
                values[i1][i2][length] = 1;
                return true;
            }

            if (dfs(i1, i2 + length - i, i) && dfs(i1 + i, i2, length - i)) {
                values[i1][i2][length] = 1;
                return true;
            }
        }
        values[i1][i2][length] = -1;
        return false;
    }

    private boolean similar(int i1, int i2, int length) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = i1; i < i1 + length; i++) {
            char c = this.s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = i2; i < i2 + length; i++) {
            char c = this.s2.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
