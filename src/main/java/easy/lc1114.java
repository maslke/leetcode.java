package easy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
class Foo {
    private CountDownLatch latch1;
    private CountDownLatch latch2;
    public Foo() {
        this.latch1 = new CountDownLatch(1);
        this.latch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        latch1.countDown();
        // printFirst.run() outputs "first". Do not change or remove this line.
        // printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch1.await();
        printSecond.run();
        latch2.countDown();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        // printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch2.await();
        printThird.run();
        // printThird.run() outputs "third". Do not change or remove this line.
        //printThird.run();
    }
}


class Foo2 {
    private AtomicInteger value;
    public Foo2() {
        this.value = new AtomicInteger(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        this.value.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (this.value.get() <= 2) {
            int val = this.value.get();
            if (val != 2) {
                continue;
            }
            printSecond.run();
            this.value.incrementAndGet();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (this.value.get() <= 3) {
            int val = this.value.get();
            if (val != 3) {
                continue;
            }
            printThird.run();
            this.value.incrementAndGet();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        //printThird.run();
    }
}