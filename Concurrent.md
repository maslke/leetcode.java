# Array(4/154)
No.|Title|Difficulty|Solved|Date
--|:--:|--:|--:|--:|
1116|[Zero Even Odd](https://leetcode-cn.com/problems/print-zero-even-odd/)|Medium|yes|2020-01-06
1117|[Building H2O](https://leetcode.com/problems/building-h2o/)|Medium|yes|2020-01-07
----------------------------------------------------------------
1116. [Zero Even Odd](https://leetcode-cn.com/problems/print-zero-even-odd/)

使用Semaphore来实现

```java
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
```

1117. [Building H2O](https://leetcode.com/problems/building-h2o/)

同样使用Semaphore来实现，不过存在限制。限制是无法输出OHH这种情况。

```java

class H2O {
    
    private Semaphore s1 = new Semaphore(2);
    private Semaphore s2 = new Semaphore(0);

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		s1.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        s2.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        s2.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        s1.release(2);
    }
}
```

可以在此基础上，额外使用CyclicBarrier。

```java
class H2O {
    
    private Semaphore s1 = new Semaphore(2);
    private Semaphore s2 = new Semaphore(1);
    private CyclicBarrier cb = new CyclicBarrier(3);

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		s1.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            cb.await();
        } catch (Exception ex) {}
        s1.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        s2.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        try {
            cb.await();
        } catch (Exception ex) {}
        s2.release();
    }
}
```