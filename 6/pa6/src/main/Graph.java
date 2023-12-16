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
    }

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
        return null;
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
        return null;
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
        return -1;
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
        return -1;
    }

    @Override
    public ArrayList<Edge> minSpanningTree() {
        /*
         * Function input:
         *  - none
         *
         * Does:
         * returns an ArrayList containing all the edges in a minimum spanning tree of the graph.
         * if there are multiple MSTs, returns one of them.
         */
        return null;
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
        return -1;
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
        return false;
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
        return -1;
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
        return null;
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
        return -1;
    }
}
