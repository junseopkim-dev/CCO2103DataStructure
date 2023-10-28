/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
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
    private Heap<JobWrapper> jobPool;

    // patience 처리를 위한 임의의 클래스 정의
    private class JobWrapper implements Comparable<JobWrapper>{
        private IJob job;

        public JobWrapper(IJob job){
            this.job = job;
        }

        @Override
        public int compareTo(JobWrapper other){
            int patienceComparison = Integer.compare(this.job.getPatience(), other.job.getPatience());

            if(patienceComparison !=0){
                return patienceComparison;
            }
            return Integer.compare(this.job.getPid(), other.job.getPid());
        }

    }
    //

    Scheduler() {
        /*
         * implement your constructor here.
         */
        jobPool = new Heap<>();
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
        jobPool.insert(new JobWrapper(j));
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
        if(jobPool.isEmpty()){
            return null;
        }

        JobWrapper jobWrapper = jobPool.removeMin();
        jobWrapper.job.serve();

        if(jobWrapper.job.isDone()){
            return jobWrapper.job;
        }
        else{
            jobPool.insert(jobWrapper);
            return null;
        }
    }
}
