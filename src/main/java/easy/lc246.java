package easy;

// https://leetcode-cn.com/problems/strobogrammatic-number/
// 246. 中心对称数

class lc246 {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        if (j == 0) {
            return "018".indexOf(num) >= 0;
        }
        while (i <= j) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(j);
            if ((c1 == c2 && (c1 == '1' || c1 == '0' || c1 == '8')) || (c1 == '6' && c2 == '9') || (c1 == '9' && c2 == '6')) {
                i++;
                j--;
            } else
            return false;
        }
        return true;
    }
}