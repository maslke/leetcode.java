package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// https://leetcode-cn.com/problems/design-bounded-blocking-queue/
// 1188. 设计有限阻塞队列
class BoundedBlockingQueue {

    private Queue<Integer> list;
    private int capacity;

    private ReentrantLock lock;
    private Condition notEmpty;
    private Condition notFull;

    public BoundedBlockingQueue(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }
    
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {

            while (list.size() == this.capacity) {
                            notFull.await();

            }
            list.offer(element);
            notEmpty.signal();
        }
        finally {
            lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (list.isEmpty()) {
            notEmpty.await();

            }
            int ret = list.poll();
            notFull.signal();
            return ret;
        } finally {
            lock.unlock();
        }
    }
    
    public int size() {
        lock.lock();
        try {
            return list.size();
        }
        finally {
            lock.unlock();
        }
    }
}