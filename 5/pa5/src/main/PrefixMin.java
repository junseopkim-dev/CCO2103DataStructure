/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */


public final class PrefixMin implements IPrefixMin{
    /*
     * you may declare additional variables here
     */

    PrefixMin() {
        /*
         * implement your constructor here.
         */
    }

    @Override
    public int getValue(YonseiString key) {
        /*
         * Function input:
         *  + a YonseiString object key
         *
         * Does:
         * if there exists an entry with the given key, returns the value associated with the given key.
         * otherwise, returns Integer.MIN_VALUE.
         */
        return -1;
    }

    @Override
    public void insert(YonseiString key, int value) {
        /*
         * Function input:
         *  + an entry of the pair (key, value)
         *
         * Does:
         * if there does not exist an entry with the given key, insert the given entry.
         * otherwise, do nothing.
         */
    }

    @Override
    public void remove(YonseiString key) {
        /*
         * Function input:
         *  + a YonseiString object key
         *
         * Does:
         * if there exists an entry with the given key, then remove that entry.
         * otherwise, do nothing.
         */
    }

    @Override
    public void clear() {
        /*
         * Function input:
         *  none
         *
         * Does:
         * removes all entries from this instance.
         */
    }

    @Override
    public int getMin(YonseiString query) {
        /*
         * Function input:
         *  + a YonseiString object query
         *
         * Does:
         * returns the minimum value over all entries which have the query as a proper prefix of the entry's key.
         * if there are no such entries, then return Integer.MIN_VALUE.
         */
        return -1;
    }
}
