package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A.isEmpty()) {
            return;
        }
        int target = A.get(0);
        A.remove(0);
        hanota(A, B, C);
        C.add(0, target);
        hanota(B, A, C);
    }

    public void move(List<Integer> A, List<Integer> B, List<Integer> C, int size) {
        if (size == 1) {
          C.add(0, A.get(0));
          A.remove(0);
        } else {
            move(A, C, B, size - 1);
            move(A, B, C, 1);
            move(B, A, C, size - 1);
        }
    }

    public static void main(String[] args) {
        lc0806 instance = new lc0806();
        List<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        // instance.hanota(A, B, C);
        instance.move(A, B, C, 5);
        System.out.println(A);
        System.out.println(C);
    }
}
