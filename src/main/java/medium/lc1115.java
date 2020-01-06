package medium;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

// https://leetcode-cn.com/problems/print-foobar-alternately/
class FooBar {
    private int n;
    private Semaphore s1;
    private Semaphore s2;

    public FooBar(int n) {
        this.n = n;
        this.s1 = new Semaphore(0);
        this.s2 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            printFoo.run();
            s2.release();
            s1.acquire();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s2.acquire();
            printBar.run();
            s1.release();
        }
    }
}

// 在leetcode中会超时
class FooBar2 {
    private int n;
    private AtomicInteger value;

    public FooBar2(int n) {
        this.n = n;
        this.value = new AtomicInteger(n * 2);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            int val = this.value.get();
            if (val % 2 != 1) {
                i--;
                continue;
            }
            printFoo.run();
            this.value.incrementAndGet();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            int val = this.value.get();
            if (val % 2 != 0) {
                i--;
                continue;
            }
            printBar.run();
            this.value.incrementAndGet();
        }
    }
}