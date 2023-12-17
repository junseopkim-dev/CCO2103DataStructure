import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Iterator;

// Main.java file is not for submission.
// It is here for you to give means of testing.
// You can use any packages in "this" file but be careful on the submission files.

public class Main {
	public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);

//		ArrayList<Integer> keys = new ArrayList<Integer>();
//		ArrayList<Integer> keys2 = new ArrayList<Integer>(Arrays.asList(3,1,4,1,5,9,2,6,5,3,5,8,9,7,9));
//
//
//		System.out.println(keys2.get(0));


		Graph g1 = new Graph();
		Node[] n1 = new Node[5];
		for(int i = 0; i < 5; i++)
		{
			n1[i] = g1.addNode();
		}
		g1.addEdge(n1[0], n1[1], 3);

		g1.addEdge(n1[1], n1[2], 5);
		g1.addEdge(n1[1], n1[2], 2);
		g1.addEdge(n1[2], n1[1], 1);

		g1.addEdge(n1[3], n1[4], 100);

		System.out.println(g1.getNumNodes()); //5
		System.out.println(g1.getNumEdges()); //3

		System.out.println("-------------------------------------------------");

		//-----------------------------------------------

		Graph g2 = new Graph();
		Node[] n2 = new Node[7];
		for (int i = 0; i < 7; i++) {
			n2[i] = g2.addNode();
		}
		g2.addEdge(n2[0], n2[1], 2);
		g2.addEdge(n2[1], n2[2], 4);
		g2.addEdge(n2[2], n2[3], 5);
		g2.addEdge(n2[3], n2[0], 6);
		g2.addEdge(n2[1], n2[3], 3);
		g2.addEdge(n2[5], n2[4], 7);
		g2.addEdge(n2[4], n2[6], 9);
		g2.addEdge(n2[5], n2[6], 8);
		g2.addEdge(n2[0], n2[4], 10);
		g2.addEdge(n2[4], n2[0], 1);

		System.out.println(g2.getNumNodes()); //7
		System.out.println(g2.getNumEdges()); //9
		System.out.println(g2.minSpanningTreeWeight()); //34
		System.out.println(g2.minSpanningTree());

		System.out.println("-------------------------------------------------");

		//-----------------------------------------------



		Graph g3 = new Graph();
		Node[] n3 = new Node[6];
		for (int i = 0; i < 6; i++) {
			n3[i] = g3.addNode();
		}
		g3.addEdge(n3[0], n3[1], 2);
		g3.addEdge(n3[1], n3[3], 7);
		g3.addEdge(n3[3], n3[5], 4);
		g3.addEdge(n3[5], n3[4], 3);
		g3.addEdge(n3[4], n3[0], 7);
		g3.addEdge(n3[1], n3[2], 5);
		g3.addEdge(n3[2], n3[3], 9);
		g3.addEdge(n3[0], n3[2], 8);
		g3.addEdge(n3[2], n3[4], 8);

		System.out.println(g3.getNumNodes()); // 6
		System.out.println(g3.getNumEdges()); // 9
		System.out.println(g3.minSpanningTreeWeight()); // 21
		System.out.println(g3.minSpanningTree());

		System.out.println("-------------------------------------------------");

		//-----------------------------------------------


		Graph g4 = new Graph();
		Node[] n4 = new Node[6];
		for (int i = 0; i < 6; i++) {
			n4[i] = g4.addNode();
		}
		g4.addEdge(n4[0], n4[1], 8);
		g4.addEdge(n4[1], n4[2], 3);
		g4.addEdge(n4[2], n4[3], 2);
		g4.addEdge(n4[3], n4[4], 4);
		g4.addEdge(n4[4], n4[5], 3);
		g4.addEdge(n4[5], n4[0], 7);
		g4.addEdge(n4[1], n4[3], 1);
		g4.addEdge(n4[1], n4[4], 9);
		g4.addEdge(n4[0], n4[3], 6);

		System.out.println(g4.getNumNodes()); // 6
		System.out.println(g4.getNumEdges()); // 9
		System.out.println(g4.minSpanningTreeWeight()); // 16
		System.out.println(g4.minSpanningTree());
		System.out.println(g4.isConnected()); //true
		System.out.println(g4.numConnnectedComponents()); // 1

		System.out.println("-------------------------------------------------");
		//-----------------------------------------------


		Graph g5 = new Graph();
		Node[] n5 = new Node[7];
		for (int i = 0; i < 7; i++) {
			n5[i] = g5.addNode();
		}
		g5.addEdge(n5[0], n5[1], 2);
		g5.addEdge(n5[1], n5[2], 4);
		g5.addEdge(n5[2], n5[3], 5);
		g5.addEdge(n5[3], n5[0], 6);
		g5.addEdge(n5[1], n5[3], 3);
		g5.addEdge(n5[5], n5[4], 7);
		g5.addEdge(n5[4], n5[6], 9);
		g5.addEdge(n5[5], n5[6], 8);
//		g5.addEdge(n5[0], n5[4], 10);

		System.out.println(g5.getNumNodes()); //7
		System.out.println(g5.getNumEdges()); //8
		System.out.println(g5.minSpanningTreeWeight()); //9
		System.out.println(g5.minSpanningTree());
		System.out.println(g5.isConnected()); //false
		System.out.println(g5.areUVConnected(n5[5], n5[4])); //true
		System.out.println(g5.areUVConnected(n5[5], n5[1])); //false
		System.out.println(g5.areUVConnected(n5[0], n5[6])); //false
		System.out.println(g5.dijkstra(n5[0]));
		System.out.println(g5.shortestPathLength(n5[0], n5[1])); //2
		System.out.println(g5.shortestPathLength(n5[0], n5[2])); //6
		System.out.println(g5.shortestPathLength(n5[0], n5[3])); //5
		System.out.println(g5.shortestPathLength(n5[0], n5[4])); //무한
		System.out.println(g5.shortestPathLength(n5[0], n5[5])); //무한
		System.out.println(g5.shortestPathLength(n5[0], n5[6])); //무한
		System.out.println(g5.shortestPathLength(n5[1], n5[2])); //4
		System.out.println(g5.shortestPathLength(n5[1], n5[0])); //2
		System.out.println(g5.shortestPathLength(n5[1], n5[5])); //무한
		System.out.println(g5.numConnnectedComponents()); //2


		System.out.println("-------------------------------------------------");

		Graph g6 = new Graph();
		Node[] n6 = new Node[7];
		for (int i = 0; i < 7; i++) {
			n6[i] = g6.addNode();
		}

		System.out.println(g6.getNumNodes()); //7
		System.out.println(g6.getNumEdges()); //0
		System.out.println(g6.minSpanningTreeWeight()); //0
		System.out.println(g6.isConnected()); //false
		System.out.println(g6.areUVConnected(n6[5], n6[4])); //false
		System.out.println(g6.numConnnectedComponents()); //7

		g6.addEdge(n6[0], n6[1], 2);
		g6.addEdge(n6[1], n6[0], 10);

		System.out.println(g6.getNumEdges()); //1
		System.out.println(g6.numConnnectedComponents()); //6

		System.out.println("-------------------------------------------------");

		Graph g7 = new Graph();
		Node[] n7 = new Node[9];
		for (int i = 0; i < 9; i++) {
			n7[i] = g7.addNode();
		}
		g7.addEdge(n7[0], n7[1], 8);
		g7.addEdge(n7[1], n7[4], 9);
		g7.addEdge(n7[4], n7[5], 19);
		g7.addEdge(n7[5], n7[7], 11);
		g7.addEdge(n7[7], n7[8], 9);
		g7.addEdge(n7[8], n7[6], 11);
		g7.addEdge(n7[6], n7[2], 21);
		g7.addEdge(n7[2], n7[0], 12);

		g7.addEdge(n7[1], n7[2], 13);
		g7.addEdge(n7[2], n7[3], 14);
		g7.addEdge(n7[1], n7[3], 25);
		g7.addEdge(n7[4], n7[3], 20);
		g7.addEdge(n7[5], n7[3], 8);
		g7.addEdge(n7[7], n7[3], 12);
		g7.addEdge(n7[8], n7[3], 16);
		g7.addEdge(n7[6], n7[3], 12);


		System.out.println(g7.getNumNodes());//9
		System.out.println(g7.getNumEdges()); //16
		System.out.println(g7.minSpanningTreeWeight()); // 82
		System.out.println(g7.isConnected()); //true
		System.out.println(g7.areUVConnected(n7[5], n7[4])); //true
		System.out.println(g7.numConnnectedComponents()); //1
		System.out.println(g7.shortestPathLength(n7[0], n7[6])); //33

	}
}