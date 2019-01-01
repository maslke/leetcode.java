

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 38. Count and Say
 */
public class lc38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String ret = "1";
        for (int i = 2; i <= n; i++) {
            int len = ret.length();
            String temp ="";
            for (int j = 0; j < len; j++) {
                char c = ret.charAt(j);
                int count = 1;
                int k = j + 1;
                for (; k < len; k++) {
                    if (c == ret.charAt(k)) {
                        count++;
                    } else {
                        k--;
                        break;
                    }
                }
                j = k;
                temp = temp + count + Character.toString(c);
            }
            ret = temp;
        }
        return ret;
    }
}
