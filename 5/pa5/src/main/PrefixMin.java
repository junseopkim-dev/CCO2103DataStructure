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
    //Trie로 구현
    /*
     * you may declare additional variables here
     */
    Node root;

    //custom methods starts
    private class Node{
        int value;
        Node[] children;

        Node() { //생성자
            this.value = Integer.MIN_VALUE;
            this.children = new Node[200];
        }
    }

    private boolean isEmpty(Node node){
        if(node == null){
            return true;
        }

        if(node.value != Integer.MIN_VALUE){
            return false;
        }

        for(Node child : node.children){
            if(child != null){
                return false;
            }
        }
        return true;
    }

    private void remove(Node node, YonseiString key, int depth){
        if (node == null){
            return;
        }
        if (depth == key.length()){
            node.value = Integer.MIN_VALUE;

            return;
        }
        int index = key.charAt(depth);
        remove(node.children[index],key,depth+1); //재귀적으로 호출

        if (isEmpty(node.children[index])){
            node.children[index] = null;
        }
    }



    private int getMin(Node node, YonseiString query, int depth){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        if(depth == query.length()){
            int minInSubtree = findMin(node);
            if(minInSubtree != Integer.MIN_VALUE){
                return minInSubtree;
            }
            else{
                return Integer.MIN_VALUE;
            }
        }
        int index = query.charAt(depth);
        return getMin(node.children[index],query,depth+1);
    }

    private int findMin(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        if(node.value != Integer.MIN_VALUE && node.children == null){
            return node.value;
        }
        int min = node.value;
        for(Node child : node.children){
            int childMin = findMin(child);
            if(childMin != Integer.MIN_VALUE){
                if(min == Integer.MIN_VALUE || childMin <min){

                    min = childMin;
                }
            }
        }
        return min;
    }

    //custom methods ends

    PrefixMin() { //생성자
        /*
         * implement your constructor here.
         */
        root = new Node();
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

        Node node = root;


        for(int i = 0; i < key.length(); i++){

            int index = key.charAt(i);

            if(node.children[index] == null){

                return Integer.MIN_VALUE;
            }
            node = node.children[index];
        }
        return node.value;
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
        Node node = root;
        for (int i = 0; i < key.length(); i++){
            int index = key.charAt(i);
            if (node.children[index] == null){
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        if (node.value == Integer.MIN_VALUE){
            node.value = value;
        }
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

        remove(root,key,0);
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


        root = new Node();
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
        return getMin(root,query,0);
    }


}
