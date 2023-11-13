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
    private Heap<Task> heap;

    // patience 처리를 위한 임의의 클래스 정의
    private class Task implements Comparable<Task>{
        private IJob job;

        public Task(IJob job){
            this.job = job;
        }

        @Override
        public int compareTo(Task other){
            int comp = Integer.compare(this.job.getPatience(), other.job.getPatience());

            if(comp !=0){
                return comp;
            }
            return Integer.compare(this.job.getPid(), other.job.getPid());
        }

    }
    //

    Scheduler() {
        /*
         * implement your constructor here.
         */
        heap = new Heap<>();
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
        heap.insert(new Task(j));
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
        if(heap.isEmpty()){
            return null;
        }

        Task Task = heap.removeMin();
        Task.job.serve();

        if(Task.job.isDone()){
            return Task.job;
        }
        else{
            heap.insert(Task);
            return null;
        }
    }
}
