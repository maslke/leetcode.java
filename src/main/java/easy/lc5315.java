package easy;

class lc5315 {
    public int maximum69Number(int num) {
        String val = String.valueOf(num);
        char[] chars = val.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '') {
                chars[i] = '9';
                break;
            }
        }

        return Integer.valueOf(new String(chars));
    }

    public int maximum69Number2(int num) {
        String v = String.valueOf(num);
        int index = v.indexOf('6');
        if (index >= 0) {
            return num + 3 * (int)(Math.pow(10, v.length() - index - 1));
        }
        return num;
        
}
}