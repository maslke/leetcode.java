package easy;

// https://leetcode-cn.com/problems/three-in-one-lcci/
// 面试题 03.01. 三合一

public class TripleInOne {

    private int[] values;
    private int inx1;
    private int inx2;
    private int inx3;
    private int size;

    public TripleInOne(int stackSize) {
        size = stackSize * 3;
        values = new int[size];
        this.inx1 = 0;
        this.inx2 = 1;
        this.inx3 = 2;
    }

    public void push(int stackNum, int value) {
        if (stackNum == 2) {
            if (inx3 < size) {
                values[inx3] = value;
                inx3 += 3;
            }
        } else if (stackNum == 1) {
            if (inx2 < size - 1) {
                values[inx2] = value;
                inx2 += 3;
            }
        } else {
            if (inx1 < size - 2) {
                values[inx1] = value;
                inx1 += 3;
            }
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        if (stackNum == 0) {
            inx1 -= 3;
            return values[inx1];

        } else if (stackNum == 1) {
            inx2 -= 3;
            return values[inx2];
        } else {
            inx3 -= 3;
            return values[inx3];
        }
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        if (stackNum == 0) {
            return values[inx1 - 3];
        } else if (stackNum == 1) {
            return values[inx2 - 3];
        } else {
            return values[inx3 - 3];
        }
    }

    public boolean isEmpty(int stackNum) {
        if (stackNum == 0) {
            return this.inx1 == 0;
        } else if (stackNum == 1) {
            return this.inx2 == 1;
        } else {
            return this.inx3 == 2;
        }
    }
}
