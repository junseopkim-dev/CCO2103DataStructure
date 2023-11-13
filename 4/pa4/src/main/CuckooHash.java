/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

import java.util.Random; // you can use Random in this file.

public final class CuckooHash implements ICuckooHash{
    int a1, a2, b1, b2, N; // do not change the signatures
    /*
     * you may declare additional variables here
     */

    CuckooHash(double threshold, int chainLength, int N) {
        /*
         * implement your constructor here.
         */
    }

    @Override
    public boolean contains(int x) {
        /*
         * Function input:
         *  + an integer x
         *
         * Does:
         * returns true if x is in the hash table. returns false otherwise.
         */
        return false;
    }

    @Override
    public void delete(int x) {
        /*
         * Function input:
         *  + an integer x
         *
         * Does:
         * if x is in the hash table, deletes x from the hash table.
         * otherwise, do nothing.
         */
    }

    @Override
    public void insert(int x) {
        /*
         * Function input:
         *  + an integer x
         *
         * Does:
         * if x is not in the hash table, inserts x to the hash table according to the behavior specification.
         * otherwise, do nothing.
         */
    }

    // implemented for you. do not change this method.
    @Override
    public HashParameter getParams() {
        return new HashParameter(a1, a2, b1, b2, N);
    }
}
