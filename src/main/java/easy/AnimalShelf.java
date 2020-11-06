package easy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelf {

    private Queue<int[]> queue;

    public AnimalShelf() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        this.queue.offer(animal);
    }

    public int[] dequeueAny() {
        if (this.queue.isEmpty()) {
            return new int[] {-1, -1};
        }
        return this.queue.poll();
    }

    public int[] dequeueDog() {
        Iterator<int[]> iterator = this.queue.iterator();
        while (iterator.hasNext()) {
            int[] animal = iterator.next();
            if (animal[1] == 1) {
                iterator.remove();
                return animal;
            }
        }
        return new int[] {-1, -1};
    }

    public int[] dequeueCat() {
        Iterator<int[]> iterator = this.queue.iterator();
        while (iterator.hasNext()) {
            int[] animal = iterator.next();
            if (animal[1] == 0) {
                iterator.remove();
                return animal;
            }
        }
        return new int[] {-1, -1};
    }
}
