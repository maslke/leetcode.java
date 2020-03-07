package easy;

// https://leetcode-cn.com/problems/hexspeak/
// 1271. 十六进制魔术数字

class lc1271 {
    public String toHexspeak(String num) {
        String value = Long.toHexString(Long.valueOf(num));
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                chars[i] = 'I';
            }
            if (chars[i] == '0') {
                chars[i] = 'O';
            }
            if (chars[i] >= '2' && chars[i] <= '9') {
                return "ERROR";
            }
        } 
        return new String(chars).toUpperCase();
    }
}