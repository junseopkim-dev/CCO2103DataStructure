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



    int emptyValue = Integer.MIN_VALUE;
    int[] A1, A2; // 해쉬테이블 2개 A1,A2
    double threshold;
    int chainLength;
    int size;
    Random rand = new Random();
    Queue Order = new Queue();


    CuckooHash(double threshold, int chainLength, int N) {
        /*
         * implement your constructor here.
         */

        this.threshold = threshold;
        this.chainLength = chainLength;
        this.N = N;
        this.A1 = new int[N];
        this.A2 = new int[N];
        this.size = 0;
        for (int i = 0; i<N; i++){
            A1[i] = emptyValue;
            A2[i] = emptyValue;
        }
        HFParams();
    }

    //custom methods starts

    private class Node{
        int E;
        Node next;

        Node(int E){
            this.E = E;
        }
    }

    //큐 이용한 구현
    private class Queue{
        Node head;
        Node tail;
        int size;

        Queue(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        void push(Node N){
            if (this.size == 0) {
                this.head = N;
                this.tail = N;
                size++;
            }
            else{
                this.tail.next = N;
                this.tail = N;
                size++;
            }

        }

        int pop() {
            if (this.size==1){
                int popped = this.head.E;
                this.head = null;
                this.tail = null;
                this.size = 0;
                return popped;
            }
            int popped = this.head.E;
            this.head = this.head.next;
            size--;
            return popped;
        }
    }
    private void HFParams(){
        //hash function의 매개변수를 조건에 맞는 난수로 설정
        a1 = rand.nextInt(N-1) + 1;
        a2 = rand.nextInt(N-1) + 1;
        b1 = rand.nextInt(N);
        b2 = rand.nextInt(N);
    }

    private int h1(int x){
        return (((this.a1 * x + this.b1) %this.N)+this.N)%this.N;
    }


    private int h2(int x){
        return (((this.a2 * x + this.b2) %this.N)+this.N)%this.N;
    }

    private int h(int a, int b, int N, int x) {
        return (((a * x + b) % N)+N)%N;
    }

    private void insertA1(int x) {
        int Hash1 = this.h1(x);
        A1[Hash1] = x;
    }

    private void insertA2(int x) {
        int Hash2 = this.h2(x);
        A2[Hash2] = x;
    }

    private void resize() {
        HashParameter prevParams = this.getParams();
        int[] prevA1 = this.A1;
        int[] prevA2 = this.A2;
        Queue prevOrder = this.Order;
        N *= 2;
        this.A1 = new int[N];
        this.A2 = new int[N];
        for (int i = 0; i<N; i++){
            A1[i] = emptyValue;
            A2[i] = emptyValue;
        }
        this.Order = new Queue();
        this.size = 0;
        HFParams();

        while (prevOrder.size > 0) {
            int currentE = prevOrder.pop();
            int prevHash1 = h(prevParams.a1, prevParams.b1, prevParams.N, currentE);
            int prevHash2 = h(prevParams.a2, prevParams.b2, prevParams.N, currentE);
            if (prevA1[prevHash1] == currentE) {
                this.insert(currentE);
                continue;
            }
            if (prevA2[prevHash2] == currentE) {
                this.insert(currentE);
            }
        }
    }




    //custom methods ends

    @Override
    public boolean contains(int x) {
        /*
         * Function input:
         *  + an integer x
         *
         * Does:
         * returns true if x is in the hash table. returns false otherwise.
         */
        int Hash1 = this.h1(x);
        int Hash2 = this.h2(x);
        return A1[Hash1] == x || A2[Hash2] == x;

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



        int Hash1 = this.h1(x);
        int Hash2 = this.h2(x);
        if (A1[Hash1] ==x){
            A1[Hash1] = emptyValue;
            size --;
        }
        else if(A2[Hash2] == x){
            A2[Hash2] = emptyValue;
            size --;
        }
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
        if (contains(x)) {
            return;
        }
        this.Order.push(new Node(x));

        if (((double) (this.size + 1) / (2 * this.N)) >= this.threshold) {
            this.resize();
            this.insert(x);
        }
        else{
            int chain = 0;
            while (true){
                int Hash1 = this.h1(x);
                if (A1[Hash1] != emptyValue) {
                    int temp = this.A1[Hash1];
                    insertA1(x);
                    x = temp;
                    chain += 1;
                }
                else{
                    A1[Hash1] = x;
                    break;
                }

                if (chain >= this.chainLength){
                    resize();
                    this.insert(x);
                    break;
                }

                int Hash2 = this.h2(x);
                if (A2[Hash2] != emptyValue) {
                    int temp = A2[Hash2];
                    this.insertA2(x);
                    x = temp;
                    chain += 1;
                }
                else{
                    A2[Hash2] = x;
                    break;
                }

                if (chain >= this.chainLength) {
                    resize();
                    this.insert(x);
                    break;
                }
            }
        }
    }



    // implemented for you. do not change this method.
    @Override
    public HashParameter getParams() {
        return new HashParameter(a1, a2, b1, b2, N);
    }
}
