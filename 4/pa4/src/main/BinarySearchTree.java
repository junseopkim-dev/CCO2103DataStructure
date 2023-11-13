/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class BinarySearchTree<T extends Comparable> implements IBinarySearchTree<T> {
    /*
     * you may declare variables here
     */

    BinarySearchTree() {
        /*
         * implement your constructor here.
         */
    }

    @Override
    public boolean contains(T entry) {
        /*
         * Function input:
         *  + entry: target entry.
         *
         * Does:
         * returns true if the binary search tree contains the given entry. otherwise returns false.
         */
        return false;
    }

    @Override
    public void put(T entry) {
        /*
         * Function input:
         *  + entry: entry to put in the BST.
         *
         * Does:
         * if entry is not in the binary search tree, inserts entry into the binary search tree.
         * otherwise do nothing.
         */
    }

    @Override
    public void remove(T entry) {
        /*
         * Function input:
         *  + entry: entry to remove from the BST.
         *
         * Does:
         * if entry is in the binary search tree, removes entry from the binary search tree.
         * otherwise do nothing.
         */
    }

    @Override
    public void clear() {
        /*
         * Function input:
         *  none
         *
         * Does:
         * removes all entries from the binary search tree.
         */
    }

    @Override
    public int getSize() {
        /*
         * Function input:
         *  none
         *
         * Does:
         * returns the number of entries in the binary search tree.
         */
        return -1;
    }

    @Override
    public T getNext(T threshold) {
        /*
         * Function input:
         *  + threshold: comparison object.
         *
         * Does:
         * returns the element with the minimum key that is greater than the key of the given threshold object.
         */
        return null;
    }

    @Override
    public T getPrev(T threshold) {
        /*
         * Function input:
         *  + threshold: comparison object.
         *
         * Does:
         * returns the element with the maximum key that is no greater than the key of the given threshold object.
         */
        return null;
    }
}
