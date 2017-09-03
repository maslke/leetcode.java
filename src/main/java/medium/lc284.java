package medium;

import java.util.Iterator;

/**
 * Author:maslke
 * Date:2017/9/4
 * Version:0.0.1
 * 284. Peeking Iterator
 */
public class lc284 {
    int peek;
    boolean has;
    Iterator<Integer> iter;
    //PeekingIterator
    public lc284(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (has) {
            return peek;
        } else {
            peek = iter.next();
            has = true;
            return peek;
        }

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        if (has) {
            has = false;
            return peek;
        } else {
            return iter.next();
        }

    }

    public boolean hasNext() {
        return has || iter.hasNext();
    }
}
