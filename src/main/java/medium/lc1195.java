package medium;
import java.util.concurrent.atomic.AtomicInteger;
// https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
// 1195. 交替打印字符串
class FizzBuzz {
    private int n;
    private AtomicInteger value;

    public FizzBuzz(int n) {
        this.n = n;
        this.value = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (this.value.get() <= n) {
            int value = this.value.get();
            if (value <= n && value % 3 == 0 && value % 5 != 0) {
                printFizz.run();
                this.value.incrementAndGet();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (this.value.get() <= n) {
            int value = this.value.get();
            if (value <= n && value % 3 != 0 && value % 5 == 0) {
                printBuzz.run();
                this.value.incrementAndGet();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (this.value.get() <= n) {
            int value = this.value.get();
            if (value <= n && value % 3 == 0 && value % 5 == 0) {
                printFizzBuzz.run();
                this.value.incrementAndGet();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (this.value.get() <= n) {
            int value = this.value.get();
            if (value <= n && value % 3 != 0 && value % 5 != 0) {
                printNumber.accept(value);
                this.value.incrementAndGet();
            }
        }
    }
}