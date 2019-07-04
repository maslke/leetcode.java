package easy;

// https://leetcode.com/problems/jewels-and-stones/
// 771. Jewels and Stones

class lc771 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (J.indexOf(c) >= 0)
                count++;
        }
        return count;
    }
}