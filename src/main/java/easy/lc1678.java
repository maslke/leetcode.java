package easy;

// https://leetcode-cn.com/problems/goal-parser-interpretation/
// 1678. 设计Goal解析器

public class lc1678 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int length = command.length();
        while (i < length) {
            if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i = i + 2;
                } else {
                    sb.append("al");
                    i = i + 4;
                }
            } else {
                sb.append('G');
                i++;
            }
        }

        return sb.toString();
    }
}
