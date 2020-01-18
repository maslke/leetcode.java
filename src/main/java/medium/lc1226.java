package medium;

import java.util.List;
import java.util.ArrayList;

class DiningPhilosophers {
    
    

    public DiningPhilosophers() {
        
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = 0;
        int right = 0;
        if (philosopher == 0) {
            left = 0;
            right = 4;
        } else {
            left = philosopher;
            right = philosopher - 1;
        }
        ForkHolders.getInstance().acquire(left, right);
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        ForkHolders.getInstance().release(left, right);
    }
}

class ForkHolders {
    private static ForkHolders instance = new ForkHolders();
    private ForkHolders() {}

    
    public static ForkHolders getInstance() {
        return instance;
    }
    
    private List<Integer> forks = new ArrayList<Integer>();
    
    public  synchronized void acquire(int left, int right) throws InterruptedException {
        while (forks.contains(left) || forks.contains(right)) {
            wait();
        }
        forks.add(left);
        forks.add(right);
    }
    
    public synchronized void release(int left, int right) throws InterruptedException {
        forks.remove(Integer.valueOf(left));
        forks.remove(Integer.valueOf(right));
        notify();
    }
}