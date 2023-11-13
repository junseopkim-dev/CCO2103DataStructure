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

    private int init_size = 1000;
    private T[] heap;
    private int size;

    //작업의 용이성을 위해 임의로 만든 private 메소드는 여기에 작성
    private void resize(){
        int newsize = heap.length*2;
        @SuppressWarnings("uncheked")
        T[] newheap = (T[]) new Comparable[newsize];
        System.arraycopy(heap,0,newheap,0,size);
        heap = newheap;
    }

    private void upheap(int index){
        while (index > 0){
            int parent = (index-1)/2;
            if(heap[index].compareTo(heap[parent])<0){
                T temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;
                index = parent;
            }
            else{
                break;
            }
        }
    }

    private void downheap(int index){
        while(2*index+1 < size){
            int leftchild = 2*index +1;
            int rightchild = 2*index +2;
            int smaller = leftchild;

            if(rightchild < size && heap[rightchild].compareTo(heap[leftchild])<0){ // rightchild의 값이 size보다 작고, rightChild의 값이 leftChild의 값보다 작을 때 true를 반환
                smaller = rightchild;
            }

            if(heap[index].compareTo(heap[smaller])<=0){
                break;
            }

            T temp = heap[index];
            heap[index] = heap[smaller];
            heap[smaller] = temp;
            index = smaller;
        }
    }
    //


    Heap() {
        /*
         * implement your constructor here.
         */
        this.heap = (T[]) new Comparable[init_size];
        this.size =0;
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
        if (isEmpty()){
            return null;
        }
        return heap[0];
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
        if (isEmpty()){
            return null;
        }
        T temp = heap[0];
        heap[0] = heap[size-1];
        size--;
        downheap(0); //downheap 메소드 수행
        return temp;
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
        if(size == heap.length) {
            resize(); // 사이즈 2배로 늘인 새 배열에 담는 함수 resize 수행
        }
        heap[size] = entry;
        size++;
        upheap(size-1); // heap 만들기 위해 upheap 메소드 수행

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
        size =0;
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
        return size;
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
        return size == 0;
    }

    @Override
    public void merge(Heap<T> otherHeap) { //bottom-up 방식으로 merge 수행
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

        int newsize = size + otherHeap.size;
        @SuppressWarnings("unchecked")
        T[] newheap = (T[]) new Comparable[newsize];

        System.arraycopy(heap,0,newheap,0,size);
        System.arraycopy(otherHeap.heap,0,newheap,size,otherHeap.size);

        heap = newheap;
        size = newsize;

        for (int i = (size/2)-1;i >=0; i--){
            downheap(i);
        }
    }
}
