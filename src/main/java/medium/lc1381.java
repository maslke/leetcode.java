package medium;

// https://leetcode.com/problems/design-a-stack-with-increment-operation/
// 1381. Design a Stack With Increment Operation

class CustomStack {
    
    private int size;
    private int[] values;

    public CustomStack(int maxSize) {
        this.size = 0;
        this.values = new int[maxSize];
    }
    
    public void push(int x) {
        if (size == values.length) return;
        values[size++] = x;
    }
    
    public int pop() {
        if (size == 0) return -1;
        return values[--size];
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < k && i < size; i++) {
            values[i] += val;
        }
    }
}