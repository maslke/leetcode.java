package medium;

/**
 * Author:maslke
 * Date:2017/8/26
 * Version:0.0.1
 * 165. Compare Version Numbers
 */
public class lc165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int i, j;
        for (i = 0, j = 0; i < len1 && j < len2; i++, j++) {
            int ret = Integer.valueOf(v1[i]) - Integer.valueOf(v2[j]);
            if (ret < 0) {
                return -1;
            } else if (ret > 0) {
                return 1;
            }
        }
        if (len1 == len2) {
            return 0;
        } else if (len1 > len2) {
            for (int m = i; m < len1; m++) {
                if (!v1[m].matches("^[0]+$")) {
                    return 1;
                }
            }
            return 0;
        } else {
            for (int m = j; m < len2; m++) {
                if (!v2[m].matches("^[0]+$")) {
                    return -1;
                }
            }
            return 0;
        }
    }
}
