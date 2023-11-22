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
    // AVL 트리로 구현
    
    /*
     * you may declare variables here
     */

    Node root;
    int size;

    BinarySearchTree() {
        /*
         * implement your constructor here.
         */
        root = null;
        size = 0;
    }


    //custom methods starts

    private class Node{
        T data;
        Node left, right;
        int height;

        Node(T data){
            this.data = data;
            this.height = 1;
        }
    }

    //높이
    private int height(Node N){
        if (N == null){
            return 0;
        }
        return N.height;
    }

    //balance factor
    private int getBalance(Node N){
        if (N == null){
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    private Node minValueNode(Node node){
        Node current = node;
        while (current.left != null){
            current = current.left;
        }
        return current;
    }

    private Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private boolean contains(Node node, T entry){
        if (node == null){
            return false;
        }
        int cmp = entry.compareTo(node.data);
        if (cmp < 0){
            return contains(node.left, entry);
        }
        else if (cmp > 0){
            return contains(node.right, entry);
        }
        else{
            return true;
        }
    }

    private Node put(Node node, T entry){
        if (node == null){
            size++;
            return new Node(entry);
        }
        int cmp = entry.compareTo(node.data);
        if (cmp < 0){
            node.left = put(node.left, entry);
        }
        else if (cmp > 0){
            node.right = put(node.right, entry);
        }
        else{
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // 언밸런스 4가지 경우; LL, LR, RR, RL

        // LL
        if (balance > 1 && entry.compareTo(node.left.data) < 0){
            return rightRotate(node);
        }

        // LR
        if (balance > 1 && entry.compareTo(node.left.data) > 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR
        if (balance < -1 && entry.compareTo(node.right.data) > 0){
            return leftRotate(node);
        }

        // RL
        if (balance < -1 && entry.compareTo(node.right.data) < 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }


    private Node remove(Node node, T entry){
        if (node == null){
            return node;
        }

        int cmp = entry.compareTo(node.data);
        if (cmp < 0){
            node.left = remove(node.left, entry);
        }
        else if (cmp > 0)
        {
            node.right = remove(node.right, entry);
        }
        else{
            // 자식 2개 미만인 경우
            if ((node.left == null) || (node.right == null)){
                Node temp = null;
                
                if(temp == node.left){
                    temp = node.right;
                }
                else{
                    temp = node.left;
                }

                // 자식 하나도 없는 경우
                if (temp == null){
                    temp = node;
                    node = null;
                }
                else{ 
                    // 자식 하나 있는 경우
                    node = temp;
                }
                size--;
            }
            else{
                // 자식 2개인 경우
                // inorder successor 구하기
                Node temp = minValueNode(node.right);

                // node에 inorder successor 값 대입하기
                node.data = temp.data;

                // inorder successor 지우기
                node.right = remove(node.right, temp.data);
            }
        }

        if (node == null){
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        // balance factor
        int balance = getBalance(node);

        // 언밸런스 4가지 경우; LL, LR, RR, RL

        // LL
        if (balance > 1 && getBalance(node.left) >= 0){
            return rightRotate(node);
        }

        // LR
        if (balance > 1 && getBalance(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR
        if (balance < -1 && getBalance(node.right) <= 0){
            return leftRotate(node);
        }

        // RL
        if (balance < -1 && getBalance(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private T getNext(Node node, T threshold, T current){
        if (node == null){
            return current;
        }
        int cmp = threshold.compareTo(node.data);
        if (cmp < 0){
            return getNext(node.left, threshold, node.data);
        }
        else{
            return getNext(node.right, threshold, current);
        }
    }

    private T getPrev(Node node, T threshold, T current){
        if (node == null){
            return current;
        }
        int cmp = threshold.compareTo(node.data);
        if (cmp > 0){
            return getPrev(node.right, threshold, node.data);
        }
        else{
            return getPrev(node.left, threshold, current);
        }
    }
    //custom methods ends

    @Override
    public boolean contains(T entry) {
        /*
         * Function input:
         *  + entry: target entry.
         *
         * Does:
         * returns true if the binary search tree contains the given entry. otherwise returns false.
         */
        return contains(root, entry);
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
        root = put(root, entry);
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
        root = remove(root, entry);
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
        root = null;
        size = 0;
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
        return size;
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
        return getNext(root, threshold, null);
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
        return getPrev(root, threshold, null);
    }
}
