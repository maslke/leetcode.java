package easy;

// https://leetcode-cn.com/problems/rectangle-overlap/
// 836. 矩形重叠

class lc836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]) {
            return false;
        }
        return true;
    }

   
}