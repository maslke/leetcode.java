package medium;

// https://leetcode.com/problems/rectangle-area/
// 223. Rectangle Area

class lc223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        if (B >= H || D <= F || A >= G || C <= E) {
            return sum;
        }
      
       int x1 = Math.max(A, E);
        int x2 = Math.min(C, G);
        int y1 = Math.max(B, F);
        int y2 = Math.min(D, H);
        return sum - (x2 - x1) * (y2 - y1);                
    }
    
 
    
    
}