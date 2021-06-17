package hard;

// https://leetcode-cn.com/problems/valid-number/
// 65. 有效数字

public class lc65 {
    public boolean isNumber(String s) {
        s = s.trim();
        s = s.replace('e', 'E');
        if (s.indexOf('E') == 0) {
            return false;
        }
        if (s.indexOf('E') > 0) {
            if (s.indexOf('E') != s.lastIndexOf('E')) {
                return false;
            }
            String[] parts = s.split("E");
            if (parts.length < 2) {
                return false;
            }
            parts[0] = removePrevfix(parts[0]);
            parts[1] = removePrevfix(parts[1]);
            if (parts[0].length() == 0 || parts[1].length() == 0) {
                return false;
            }
            return (isInteger(parts[0]) || isFloat(parts[0])) && isInteger(parts[1]);
        }
        s = removePrevfix(s);
        return isInteger(s) || isFloat(s);

    }

    private String removePrevfix(String s) {
        if (s.indexOf('+') == 0 || s.indexOf('-') == 0) {
            s = s.substring(1);
        }
        return s;
    }

    private boolean isInteger(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    private boolean isFloat(String s) {
        if (!s.contains(".")) {
            return false;
        }
        if (s.indexOf('.') != s.lastIndexOf('.')) {
            return false;
        }

        String[] parts = s.split("\\.");

        if (parts.length == 0) {
            return false;
        }
        if (parts.length == 1) {
            return isInteger(parts[0]);
        }

        return isInteger(parts[0]) && isInteger(parts[1]);
    }
}
