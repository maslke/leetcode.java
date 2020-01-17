package easy;

import java.util.List;
import java.util.ArrayList;

class lc989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int i = A.length - 1;
        boolean plusOne = false;
        List<Integer> result = new ArrayList<>();
        while (i >= 0 || K > 0) {
            int m = 0;
            if (i >= 0 && K > 0 ) {
                int a = A[i];
                int b = K % 10;
                m = a + b;
                i--;
                K = K / 10;
            } else if (i >= 0) {
                m = A[i];
                i--;
            } else if (K > 0) {
                m = K % 10;
                K = K / 10;
            }
            
            if (plusOne) {
                    m += 1;
                    plusOne = false;
                }
                if (m >= 10) {
                    m -= 10;
                    plusOne = true;
                }
                result.add(m);
        }
        if (plusOne) {
            result.add(1);
        }
        
        List<Integer> ret = new ArrayList<>();
        int size = result.size();
        for (int inx = size - 1; inx >= 0; inx--) {
            ret.add(result.get(inx));
        }
        
        
        return ret;
    }
}