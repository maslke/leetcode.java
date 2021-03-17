package easy;

import java.util.Iterator;
import java.util.LinkedList;

// https://leetcode-cn.com/problems/design-hashmap/
// 706.设计哈希映射

public class MyHashMap {

    class Pair {
        int key;
        int val;

        Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private LinkedList[] list;

    private int hash(int key) {
        return key % 579;
    }

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        this.list = new LinkedList[579];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int h = hash(key);
        if (list[h] == null) {
            list[h] = new LinkedList<Integer>();
        }
        LinkedList linkedlist = list[h];
        Iterator iterator = linkedlist.iterator();
        while (iterator.hasNext()) {
            Pair p = (Pair) iterator.next();
            if (p.key == key) {
                p.val = value;
                return;
            }
        }
        linkedlist.addLast(new Pair(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int h = hash(key);
        if (list[h] == null) {
            return -1;
        }
        LinkedList linkedlist = list[h];
        Iterator iterator = linkedlist.iterator();
        while (iterator.hasNext()) {
            Pair p = (Pair) iterator.next();
            if (p.key == key) {
                return p.val;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int h = hash(key);
        if (list[h] == null) {
            return;
        }
        LinkedList linkedlist = list[h];
        Iterator iterator = linkedlist.iterator();
        while (iterator.hasNext()) {
            Pair p = (Pair) iterator.next();
            if (p.key == key) {
                iterator.remove();
                break;
            }
        }
    }
}
