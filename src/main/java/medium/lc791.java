package medium;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String customSortString(String S, String T) {
        char[] chars = T.toCharArray();
       
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (compare(S, chars[i], chars[j]) > 0) {
                    swap(chars, i, j);
                }
            }
        }

        // Arrays.sort(chars, new Comparator<Character>() {
        //     @Override
        //     public int compare(Character a, Character b) {
        //         int index1 = S.indexOf(a);
        //         int index2 = S.indexOf(b);
        //         if (index1 < 0) {
        //             return 1;
        //         }        
        //         if (index2 < 0) {
        //             return -1;
        //         }
        //         return index1 - index2;
        //     }
        // });

        return new String(chars);
    }
    
    private int compare(String S, char a, char b) {
        int index1 = S.indexOf(a);
        int index2 = S.indexOf(b);
        if (index1 < 0) {
            return 1;
        }
        if (index2 < 0) {
            return -1;
        }
        return index1 - index2;
    }
    
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}