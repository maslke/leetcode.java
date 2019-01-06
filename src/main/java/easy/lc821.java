//https://leetcode.com/problems/shortest-distance-to-a-character/
//821. Shortest Distance to a Character
class Solution {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] ret = new int[len];
        List<Integer> inx = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                inx.add(i);
            }
        }
        for (int i = 0; i < len; i++) {
            ret[i] = getIndex(i, inx);
        }
        return ret;
    }
    
    private int getIndex(int i , List<Integer> inx) {
        int size = inx.size();
        if (i <= inx.get(0)) return inx.get(0) - i;
        if (i >= inx.get(size - 1)) return  i - inx.get(size - 1);
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < size; j++) {
            if (Math.abs(inx.get(j) - i) < min) {
                min = Math.abs(inx.get(j) - i);
            }
        }
        return min;
    }
}