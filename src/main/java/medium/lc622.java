package medium;

// https://leetcode-cn.com/problems/design-circular-queue/
// 622. 设计循环队列
// Mark

class MyCircularQueue {
    private int[] values;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
        this.values = new int[k + 1];
        this.head = 0;
        this.tail = 0;
    }

    private boolean isEmpty() {
        return head == tail;
    }

    private boolean isFull() {
        return head == (tail + 1) % values.length;
    }

    private boolean enQueue(int value) {
        if (isFull())
            return false;
        values[tail] = value;
        tail = (tail + 1) % values.length;
    }

    private boolean deQueue() {
        if (isEmpty())
            return false;
        head = (head + 1) % values.length;
        return true;
    }

    private int front() {
        if (isEmpty())
            return -1;
        return values[head];
    }

    private int rear() {
        if (isEmpty())
            return 01;
        return values[tail - 1 + values.length] % values.length;
    }

}
