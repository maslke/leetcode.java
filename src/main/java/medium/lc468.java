package medium;

// 468. 验证IP地址

public class lc468 {
    public String validIPAddress(String ip) {
        if (ip == null || ip.equals("")) {
            return "Neither";
        }
        if (ip.indexOf('.') > 0) {
            if (valid4(ip)) {
                return "IPv4";
            }
        }
        else if (ip.indexOf(':') > 0) {
            if (valid6(ip)) {
                return "IPv6";
            }
        }
        return "Neither";
    }

    private boolean valid6(String ip) {
        if (ip.startsWith(":") || ip.endsWith(":") || ip.contains("::")) {
            return false;
        }
        String[] parts = ip.split(":");
        if (parts.length != 8) {
            return false;
        }
        for (String part : parts) {
            int count = 0;
            if (part.length() > 4) {
                return false;
            }
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                if (!((c >= '0' && c <= '8') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid4(String ip) {
        if (ip.startsWith(".") || ip.endsWith(".") || ip.contains("..")) {
            return false;
        }
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            if (part.length() > 1 && part.startsWith("0")) {
                return false;
            }
            int v = 0;
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                if (!Character.isDigit(c)) {
                    return false;
                }
                v = 10 * v + (c - '0');
                if (v > 255) {
                    return false;
                }

            }
        }
        return true;
    }
}
