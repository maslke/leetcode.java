package easy;

//https://leetcode.com/problems/repeated-string-match/
//686. Repeated String Match
class lc686 {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int count = 1;
        while (true) {
            if (sb.length() < B.length()) {
                sb.append(A);
                count++;
            } else {
                if (sb.indexOf(B) >= 0) {
                    return count;
                } else {
                    sb.append(A);
                    count++;
                    if (sb.indexOf(B) >= 0) return count;
                    return -1;
                }
            }
        }
       // return -1;
    }

    public int repeatedStringMatch2(String a, String b) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        sb.append(a);
        if (sb.indexOf(b) == -1) {
            return -1;
        }
        int inx = sb.indexOf(a);
        return inx + b.length() > a.length() * count ? count + 1 : count;
    }
}