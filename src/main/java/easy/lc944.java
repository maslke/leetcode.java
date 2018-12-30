/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 * 944. Delete Columns to Make Sorted
 */
class Solution {
    public int minDeletionSize(String[] A) {
        int len = A.length;
        int count = 0;
        int len2 = A[0].length();
        for (int i = 0; i < len2; i++) {
            for (int j = 1; j < len; j++) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
        
    }
}