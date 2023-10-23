/*
 * Name:
 * Student ID #:
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class Scheduler implements IScheduler {
    /*
     * you may declare variables here
     */

    Scheduler() {
        /*
         * implement your constructor here.
         */
    }

    @Override
    public void register(IJob j) {
        /*
         * Function input:
         *  + j: instance of class implementing IJob.
         *
         * Does:
         * add j to the job pool.
         */
    }

    @Override
    public IJob process() {
        /*
         * Function input:
         *  none
         *
         * Does:
         * serve the job with the highest priority once.
         * between two jobs, a job has a higher priority if its patience is lower than the other job.
         * if they have the same patience, the one with the smaller pid has the higher priority.
         * if the job is done, then remove it from the job pool and return the job.
         * otherwise, do not remove the served job from the job pool and return null.
         */
        return null;
    }
}
