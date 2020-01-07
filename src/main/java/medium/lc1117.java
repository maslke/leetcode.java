package medium;
import java.util.concurrent.Semaphore;

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