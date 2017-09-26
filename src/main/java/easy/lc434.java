package easy;

/**
 * Author:maslke
 * Date:2017/9/26
 * Version:0.0.1
 * 434. Number of Segments in a String
 */
public class lc434 {
    public int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        return s.split("\\s+").length;
    }
}
