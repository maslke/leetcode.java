package medium;

/**
 * Author:maslke
 * Date:2017/9/12
 * Version:0.0.1
 * 468. Validate IP Address
 * //自己太笨了。
 */
public class lc468 {
    public String validIPAddress(String IP) {
        int length = IP.length();
        if (length == 0) {
            return "Neither";
        }
        String t = IP.substring(length - 1, length);
        if (t.equals(".") || t.equals(":")) {
            return "Neither";
        }
        if (IP.indexOf(".") > 0) {
            String[] parts = IP.split("\\.");
            if (validV4(parts)) {
                return "IPv4";
            } else {
                return "Neither";
            }
        } else if (IP.indexOf(":") > 0) {
            String[] parts = IP.split("\\:");
            if (validV6(parts)) {
                return "IPv6";
            } else {
                return "Neither";
            }
        } else {
            return "Neither";
        }
    }

    private boolean validV4(String[] parts) {
        int length = parts.length;
        if (length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            String p = parts[i];
            if (p.startsWith("0") && !p.equals("0")) {
                return false;
            }
            if (p.length() >= 4) {
                return false;
            }
            if (!p.matches("^\\d+$")) {
                return false;
            }
            int v = Integer.valueOf(p);
            if (!(v >= 0 && v <= 255)) {
                return false;
            }
        }
        return true;
    }

    private boolean validV6(String[] parts) {
        int length = parts.length;
        if (length != 8) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            String p = parts[i];
            if (p.equals("")) {
                return false;
            }
            if (p.length() >= 5) {
                return false;
            }
            for (int j = 0; j < p.length(); j++) {
                String temp = p.substring(j, j + 1);
                if (!((temp.compareTo("0") >= 0 && temp.compareTo("8") <= 0) || (temp.compareTo("a") >= 0 && temp.compareTo("f") <= 0) || (temp.compareTo("A") >= 0 && temp.compareTo("F") <= 0))) {
                    return false;
                }
            }
        }
        return true;
    }
}
