package easy;

import java.util.Iterator;
import java.util.LinkedList;

// https://leetcode-cn.com/problems/design-hashset/
// 705. 设计哈希集合

public class MyHashSet {


    private int hash(int n) {
        return n % 579;
    }

    private LinkedList[] list;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        list = new LinkedList[579];
    }

    public void add(int key) {
        int h = hash(key);
        if (contains(key)) {
            return;
        }
        if (list[h] == null) {
            list[h] = new LinkedList<Integer>();
        }
        list[h].addLast(key);
    }

    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        int h = hash(key);
        LinkedList linkedList = list[h];
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer val = (Integer) iterator.next();
            if (val == key) {
                iterator.remove();
                break;
            }
        }

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int h = hash(key);
        if (list[h] == null) {
            return false;
        }
        LinkedList linkedList = list[h];
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            if ((Integer) iterator.next() == key) {
                return true;
            }
        }
        return false;
    }
}
