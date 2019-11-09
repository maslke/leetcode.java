package medium;
import java.util.concurrent.Semaphore;
// https://leetcode-cn.com/problems/print-zero-even-odd/
class ZeroEvenOdd {
    private int n;
    private Semaphore s1;
    private Semaphore s2;
    private Semaphore s3;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.s1 = new Semaphore(0);
        this.s2 = new Semaphore(0);
        this.s3 = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            printNumber.accept(0);
            if (i % 2 == 0) {
                s2.release();
            } else {
                s3.release();
            }
            s1.acquire();
        }
        
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i= i + 2) {
            s3.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            s2.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }
}