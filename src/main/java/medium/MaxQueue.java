package medium;

import java.util.LinkedList;

// https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
// 面试题59 - II 队列的最大值 

class MaxQueue {
    private LinkedList<Integer> queue1;
    private LinkedList<Integer> queue2;

    public MaxQueue() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    private int maxValue() {
        if (this.queue2.isEmpty()) return -1;
        return this.queue2.getFirst();
    }

    private void pushLast(int value) {
        this.queue1.add(value);
        if (this.queue2.isEmpty()) {
            this.queue2.addLast(value);
        } else {
            while (!this.queue2.isEmpty() && this.queue2.getLast() < value) {
                this.queue2.removeLast();
            }
            queue2.addLast(value);
        }
    }

    private int popFront() {
        if (this.queue1.isEmpty()) return -1;
        int value = this.queue1.removeFirst();
        if (this.queue2.getFirst() == value) {
            this.queue2.removeFirst();
        }
        return value;
    }

    
}