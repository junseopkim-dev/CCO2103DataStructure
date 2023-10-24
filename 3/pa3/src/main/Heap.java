/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class Heap<T extends Comparable> implements IHeap<T> {
    /*
     * you may declare variables here
     */

    Heap() {
        /*
         * implement your constructor here.
         */
    }

    @Override
    public T min() {
        /*
         * Function input:
         *  none
         *
         * Does:
         * returns the minimum entry without removing it
         */
        return null;
    }

    @Override
    public T removeMin() {
        /*
         * Function input:
         *  none
         *
         * Does:
         * returns the minimum entry and removes it
         */
        return null;
    }

    @Override
    public void insert(T entry) {
        /*
         * Function input:
         *  + entry: entry to insert into heap.
         *
         * Does:
         * inserts the entry into the heap.
         */
    }

    @Override
    public void clear() {
        /*
         * Function input:
         *  none
         *
         * Does:
         * removes all entries of the heap.
         */
    }

    @Override
    public int getSize() {
        /*
         * Function input:
         *  none
         *
         * Does:
         * returns how many entries are currently in the heap.
         */
        return -1;
    }

    @Override
    public boolean isEmpty() {
        /*
         * Function input:
         *  none
         *
         * Does:
         * returns true if the heap has no entries. Otherwise returns false.
         */
        return false;
    }

    @Override
    public void merge(Heap<T> otherHeap) {
        /*
         * Function input:
         *  + otherHeap: heap to merge with.
         *
         * Does:
         * merge the otherHeap with this heap.
         * the result of merging should be in this heap.
         * you may assume that the otherHeap will not be used afterwards,
         * so you can change the heap structure of the otherHeap.
         * moreover, you may assume that the entries in the two heap are to be disjoint.
         */
    }
}
