package easy;

class lc1221 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int val = 0;
        for (int i  = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                val += 1;
            } else {
                val += -1;
            }
            if (val == 0) {
                count++;
            }
        }
        return count;
    }
}