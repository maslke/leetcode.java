package easy;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 */
public class lc551 {
    public boolean checkRecord(String s) {
        int sumA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                sumA++;
                if (sumA >= 2) {
                    return false;
                }
            }
        }
        return s.indexOf("LLL") < 0;
    }
}
