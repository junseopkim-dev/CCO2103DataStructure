
import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class GraphTests {
    @Test
    @Score(1)
    public void sampleTest1() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
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

            assertThat(g1.getNumNodes(), is(5));
            assertThat(g1.getNumEdges(), is(3));
        });
    }

    @Test
    @Score(1)
    public void sampleTest2() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
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

//            System.out.println(g2.getNumNodes()); //7
//            System.out.println(g2.getNumEdges()); //9
//            System.out.println(g2.minSpanningTreeWeight()); //34
//            System.out.println(g2.minSpanningTree());


            assertThat(g2.getNumNodes(), is(7));
            assertThat(g2.getNumEdges(), is(9));
            assertThat(g2.minSpanningTreeWeight(), is(34));
        });
    }

    @Test
    @Score(1)
    public void sampleTest3() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
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

            assertThat(g3.getNumNodes(), is(6));
            assertThat(g3.getNumEdges(), is(9));
            assertThat(g3.minSpanningTreeWeight(), is(21));
        });
    }

    @Test
    @Score(1)
    public void sampleTest4() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
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

//            System.out.println(g4.getNumNodes()); // 6
//            System.out.println(g4.getNumEdges()); // 9
//            System.out.println(g4.minSpanningTreeWeight()); // 16
//            System.out.println(g4.minSpanningTree());
//            System.out.println(g4.isConnected()); //true
//            System.out.println(g4.numConnnectedComponents()); // 1

            assertThat(g4.getNumNodes(), is(6));
            assertThat(g4.getNumEdges(), is(9));
            assertThat(g4.minSpanningTreeWeight(), is(16));
            assertThat(g4.isConnected(), is(true));
            assertThat(g4.numConnnectedComponents(), is(1));
        });
    }

        @Test
        @Score(1)
        public void sampleTest5() {
            assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
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

//                System.out.println(g5.getNumNodes()); //7
//                System.out.println(g5.getNumEdges()); //8
//                System.out.println(g5.minSpanningTreeWeight()); //9
//                System.out.println(g5.minSpanningTree());
//                System.out.println(g5.isConnected()); //false
//                System.out.println(g5.areUVConnected(n5[5], n5[4])); //true
//                System.out.println(g5.areUVConnected(n5[5], n5[1])); //false
//                System.out.println(g5.areUVConnected(n5[0], n5[6])); //false
//                System.out.println(g5.dijkstra(n5[0]));
//                System.out.println(g5.shortestPathLength(n5[0], n5[1])); //2
//                System.out.println(g5.shortestPathLength(n5[0], n5[2])); //6
//                System.out.println(g5.shortestPathLength(n5[0], n5[3])); //5
//                System.out.println(g5.shortestPathLength(n5[0], n5[4])); //무한
//                System.out.println(g5.shortestPathLength(n5[0], n5[5])); //무한
//                System.out.println(g5.shortestPathLength(n5[0], n5[6])); //무한
//                System.out.println(g5.shortestPathLength(n5[1], n5[2])); //4
//                System.out.println(g5.shortestPathLength(n5[1], n5[0])); //2
//                System.out.println(g5.shortestPathLength(n5[1], n5[5])); //무한
//                System.out.println(g5.numConnnectedComponents()); //2

                assertThat(g5.getNumNodes(), is(7));
                assertThat(g5.getNumEdges(), is(8));
                assertThat(g5.minSpanningTreeWeight(), is(9));
                assertThat(g5.isConnected(), is(false));
                assertThat(g5.areUVConnected(n5[5], n5[4]), is(true));
                assertThat(g5.areUVConnected(n5[5], n5[1]), is(false));
                assertThat(g5.areUVConnected(n5[0], n5[6]), is(false));
                assertThat(g5.shortestPathLength(n5[0], n5[1]), is(2));
                assertThat(g5.shortestPathLength(n5[0], n5[2]), is(6));
                assertThat(g5.shortestPathLength(n5[0], n5[3]), is(5));
                assertThat(g5.shortestPathLength(n5[0], n5[4]), is(Integer.MAX_VALUE));
                assertThat(g5.shortestPathLength(n5[0], n5[5]), is(Integer.MAX_VALUE));
                assertThat(g5.shortestPathLength(n5[0], n5[6]), is(Integer.MAX_VALUE));
                assertThat(g5.shortestPathLength(n5[1], n5[2]), is(4));
                assertThat(g5.shortestPathLength(n5[1], n5[0]), is(2));
                assertThat(g5.shortestPathLength(n5[1], n5[5]), is(Integer.MAX_VALUE));
                assertThat(g5.numConnnectedComponents(), is(2));
            });
        }

            @Test
            @Score(1)
            public void sampleTest6() {
                assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
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

                    assertThat(g6.getNumNodes(), is(7));
                    assertThat(g6.getNumEdges(), is(0));
                    assertThat(g6.minSpanningTreeWeight(), is(0));
                    assertThat(g6.isConnected(), is(false));
                    assertThat(g6.areUVConnected(n6[5], n6[4]), is(false));
                    assertThat(g6.numConnnectedComponents(), is(7));




                    g6.addEdge(n6[0], n6[1], 2);
                    g6.addEdge(n6[1], n6[0], 10);

                    System.out.println(g6.getNumEdges()); //1
                    System.out.println(g6.numConnnectedComponents()); //6

                    assertThat(g6.getNumEdges(), is(1));
                    assertThat(g6.numConnnectedComponents(), is(6));
                });
    }
}
