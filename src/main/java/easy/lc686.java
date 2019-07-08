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
}