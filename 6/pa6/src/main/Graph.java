/*
 * Name : Junseop Kim
 * Student ID # : 2019134006
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Iterator;
 
/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class Graph implements IGraph {
    private int numNodes, numEdges;
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    private HashMap<Node, HashMap<Node, Edge>> adjacencyList;
    /*
     * you may declare variables here
     */

    Graph() {
        /*
         * implement your constructor here.
         */
        numNodes = 0;
        numEdges = 0;
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
        adjacencyList = new HashMap<Node, HashMap<Node, Edge>>();
    }

    //custom methods starts

    private class ValueNode implements Comparable<ValueNode>{
        private Node node;
        private int value;

        public ValueNode(Node node, int value){
            this.node = node;
            this.value = value;
        }

        public Node getNode(){
            return node;
        }

        public int getValue(){
            return value;
        }

        public int compareTo(ValueNode n){
            return Integer.compare(this.value, n.getValue());
        }
    }

    //custom methods ends

    @Override
    public Node addNode() {
        /*
         * Function input:
         *  - none
         *
         * Does:
         * adds a new node to the graph and returns it.
         * each node in the graph should have a label from 0 and |V|-1,
         * in the order of instantiation.
         */
        Node newNode = new Node(numNodes);
        nodes.add(newNode);
        adjacencyList.put(newNode, new HashMap<Node, Edge>());
        numNodes++;

        return newNode;
    }

    @Override
    public Edge addEdge(Node u, Node v, int weight) {
        /*
         * Function input:
         *  - none
         *
         * Does:
         * adds an edge with the given endpoints and weight to the graph and returns it.
         */


        //이미 Edge(u,v) 혹은 Edge(v,u)가 존재할 경우, null 반환
        if(adjacencyList.get(u).containsKey(v)||adjacencyList.get(v).containsKey(u)){
            return null;
        }

        Edge newEdge1 = new Edge(u, v, weight);
        Edge newEdge2 = new Edge(v, u, weight);

        adjacencyList.get(u).put(v, newEdge1);
        adjacencyList.get(v).put(u, newEdge2);

        edges.add(newEdge1);
        numEdges++;

        return newEdge1;
    }

    @Override
    public int getNumNodes() {
        /*
         * Function input:
         *  - none
         *
         * Does:
         * returns the number of nodes in the graph.
         */
        return numNodes;
    }

    @Override
    public int getNumEdges() {
        /*
         * Function input:
         *  - none
         *
         * Does:
         * returns the number of nodes in the graph.
         */
        return numEdges;
    }

    @Override
    public ArrayList<Edge> minSpanningTree() { // Prim-Jarnik's Algorithm 적용
        /*
         * Function input:
         *  - none
         *
         * Does:
         * returns an ArrayList containing all the edges in a minimum spanning tree of the graph.
         * if there are multiple MSTs, returns one of them.
         */
        ArrayList<Edge> mst = new ArrayList<Edge>();
        HashSet<Node> cloud = new HashSet<Node>();
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        Node start = nodes.get(0); // nodes의 첫번째 노드(처음으로 입력된 노드)를 start로 설정
        cloud.add(start);
        for(Node n : adjacencyList.get(start).keySet()){
            pq.add(adjacencyList.get(start).get(n));
        }   // start와 연결된 모든 노드들을 pq에 추가

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            Node u = e.getU();
            Node v = e.getV();
            if(!cloud.contains(v)){
                cloud.add(v);
                mst.add(e);
                for(Node n : adjacencyList.get(v).keySet()){
                    pq.add(adjacencyList.get(v).get(n));
                }
            }
        }
        return mst;

    }

    @Override
    public int minSpanningTreeWeight() {
        /*
         * Function input:
         *  - none
         *
         * Does:
         * returns the weight of a minimum spanning tree of the graph.
         */

        int weight = 0;
        ArrayList<Edge> mst = minSpanningTree();
        for(Edge e : mst){
            weight += e.getWeight();
        }
        return weight;
    }

    @Override
    public boolean areUVConnected(Node u, Node v) {
        /*
         * Function input:
         *  - Nodes u,v
         *
         * Does:
         * returns true if u and v are connected. returns false otherwise.
         */

        ArrayList<Edge> path = new ArrayList<Edge>();
        HashSet<Node> cloud = new HashSet<Node>();

        for (Edge e : adjacencyList.get(u).values()) {
            path.add(e);
        }

        while (!path.isEmpty()) {
            Edge e = path.remove(0);
            Node n = e.getV();
            if (n.equals(v)) {
                return true;
            }
            if (!cloud.contains(n)) {
                cloud.add(n);
                for (Edge e2 : adjacencyList.get(n).values()) {
                    path.add(e2);
                }
            }
        }

        return false;

    }


    @Override
    public boolean isConnected() {
        /*
         * Function input:
         *  - none
         *
         * Does:
         * returns true if the graph consists of a single connected component. returns false otherwise.
         */
        Node start = nodes.get(0);
        ArrayList<Edge> path = new ArrayList<Edge>();
        HashSet<Node> cloud = new HashSet<Node>();

        for(Edge e : adjacencyList.get(start).values()){
            path.add(e);
        }

        while(!path.isEmpty()){
            Edge e = path.remove(0);
            Node n = e.getV();
            if(!cloud.contains(n)){
                cloud.add(n);
                for(Edge e2 : adjacencyList.get(n).values()){
                    path.add(e2);
                }
            }
        }

        if(cloud.size() == numNodes){
            return true;
        }
        else{
            return false;
        }

    }



    @Override
    public int numConnnectedComponents() {
        /*
         * Function input:
         *  - none
         *
         * Does:
         * returns the number of connected components of the graph.
         */

        HashSet<Node> cloud = new HashSet<Node>();
        int num = 0;

        for(Node n : nodes){
            if(!cloud.contains(n)){
                ArrayList<Edge> path = new ArrayList<Edge>();
                cloud.add(n);
                for(Edge e : adjacencyList.get(n).values()){
                    path.add(e);
                }
                while(!path.isEmpty()){
                    Edge e = path.remove(0);
                    Node m = e.getV();
                    if(!cloud.contains(m)){
                        cloud.add(m);
                        for(Edge e2 : adjacencyList.get(m).values()){
                            Node n2 = e2.getV();
                            if(!cloud.contains(n2)){
                                path.add(e2);
                            }
                        }
                    }
                }
                num++;
            }
        }

        return num;
    }

    @Override
    public HashMap<Node,Integer> dijkstra(Node source) {
        /*
         * Function input:
         *  - a source Node
         *
         * Does:
         * runs Dijkstra's algorithm on the graph for the given source node.
         * the HashMap should have each Node instance in the graph as the key
         * and the distance from source as the value.
         * unreachable nodes should have Integer.MAX_VALUE as the value.
         */

////        Initialize D[s] = 0 and D[v] = ∞ for each vertex v ̸= s
//
//        HashMap<Node, Integer> D = new HashMap<Node, Integer>();
//
//        for(Node n : nodes){
//            if(n.equals(source)){
//                D.put(n, 0);
//            }
//            else{
//                D.put(n, Integer.MAX_VALUE);
//            }
//        }
//
////        Let a priority queue Q contain all the vertices of G using the D labels as keys.
//
//            PriorityQueue<D> pq =
//            for(Node n : nodes){
//                pq.add(n);
//            }
//
////        while Q is not empty do
////            u ← Extract-Min(Q)
////        for each vertex v adjacent to u such that v is in Q do
////        if D[u] + w(u, v) < D[v] then
////        D[v] ← D[u] + w(u, v)
////        Change to D[v] the key of vertex v in Q.
//
//            while(!pq.isEmpty()){
//                Node u = pq.poll();
//                for(Node v : adjacencyList.get(u).keySet()){
//                    if(D.get(u) + adjacencyList.get(u).get(v).getWeight() < D.get(v)){
//                        D.put(v, D.get(u) + adjacencyList.get(u).get(v).getWeight());
//                        pq.remove(v);
//                        pq.add(v);
//                    }
//                }
//            }
//
//            return D;

        HashMap<Node, Integer> D = new HashMap<Node, Integer>();
        HashSet<Node> cloud = new HashSet<Node>();

        PriorityQueue<Edge> pqEdge = new PriorityQueue<Edge>();
        PriorityQueue<ValueNode> pqNode = new PriorityQueue<ValueNode>();
        Node start = source;

        for(Node n : nodes){
            if(n.equals(start)){
                D.put(n, 0);
            }
            else{
                D.put(n, Integer.MAX_VALUE);
            }
        }

        cloud.add(start);

        while(cloud.size() < nodes.size()){
            for(Edge e : adjacencyList.get(start).values()){
                pqEdge.add(e);
            }

            while(!pqEdge.isEmpty()){
                Edge e = pqEdge.poll();
                Node u = e.getU();
                Node v = e.getV();
                if(!cloud.contains(v)){
                    int newD = Math.min(D.get(v), D.get(u) + e.getWeight());

                    D.put(v, newD);
                    pqNode.add(new ValueNode(v, newD));
                }
            }

            if (pqNode.isEmpty()) {
                break;
            }

            ValueNode nv = pqNode.poll();
            start = nv.getNode();
            cloud.add(start);
        }

        return D;

    }







    @Override
    public int shortestPathLength(Node source, Node target) {
        /*
         * Function input:
         *  - Nodes source, target
         *
         * Does:
         * returns the length of the shortest path from source to target.
         * returns Integer.MAX_VALUE if target is unreachable from source.
         */

        HashMap<Node, Integer> D = dijkstra(source);
        return D.get(target);
    }



}
