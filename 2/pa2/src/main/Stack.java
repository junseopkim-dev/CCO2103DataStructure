/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class Stack<T> implements IStack<T> {
    /*
     * you may declare variables here
     */

    private LinkedList<T> list;

    Stack(){
        /*
         * implement your constructor here
         */
        list = new LinkedList<T>();
    }

    @Override
    public void push(T e){
        /*
         * Function input:
         *  + e: element to push
         *  
         * Job:
         * add e to Stack as the top element
         */
        list.insert(0,e);
    }

    @Override
    public T pop(){
        /*
         * Function input:
         *  none
         *
         * Job:
         * remove and return the top element.
         * if stack is empty, return null.
         */
        if(isEmpty()){
            return null;
        }
        T data = list.getData(0);
        list.remove(0);
        return data;
    }

    @Override
    public T peek(){
        /*
         * Function input:
         *  none
         * 
         * Job:
         * return the top element.
         * do not remove the returned element.
         * if stack is empty, return null.
         */
        if(isEmpty()){
            return null;
        }
        return list.getData(0);
    }

    @Override
    public void clear(){
        /*
         * Function input:
         *  none
         *  
         * Job:
         * clear the stack.
         */
        list.clear();
    }

    @Override
    public int getSize(){
        /*
         * Function input:
         *  none
         * 
         * Job:
         * return the number of elements in the stack.
         * this operation should run in O(1) time.
         */
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        /*
         * Function input:
         *  none
         * Job:
         * return true if there are no elements left in the Queue.
         * return false otherwise.
         */
        return list.getSize()==0;
    }
}
