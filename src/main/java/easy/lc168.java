package easy;

/**
 * Author:maslke
 * Date:2017/8/26
 * Version:0.0.1
 * 168. Excel Sheet Column Title
 */
public class lc168 {
    public String convertToTitle(int n) {
        if (n >= 1 && n <= 26) {
            return getSymbol(n);
        }
        String ret ="";
        while(n > 0) {
            int left = n % 26;
            ret = getSymbol(left) + ret;
            n = n / 26;
            if (left == 0) {
                n = n - 1;
            }
            if (n <= 26) {
                ret = getSymbol(n) + ret;
                break;
            }
        }
        return ret;
    }

    private String getSymbol(int n) {
        if (n == 0) {
            return "Z";
        }
        return Character.toString((char)(n + 64));
    }
}
