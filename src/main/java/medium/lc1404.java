package medium;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
// 1404. Number of Steps to Reduce a Number in Binary Representation to One
class lc1404 {
    public int numSteps(String s) {
        int count = 0;
        while (true) {
            if (s.equals("1")) break;
            count++;
            int length = s.length();
            if (s.charAt(length - 1) == '0') {
                s = s.substring(0, length - 1);
            } else {
                boolean flag = true;
                char[] chars = s.toCharArray();
                for (int i = length - 1; i >= 0; i--) {
                    if (!flag) break;
                    if (chars[i] == '1') {
                        chars[i] = '0';
                        flag = true;
                    } else {
                        chars[i] = '1';
                        flag = false;
                    }
                }
                if (flag) {
                    s = "1" + new String(chars);
                } else {
                    s = new String(chars);
                }
            }
        }
        
        return count;
    }
}