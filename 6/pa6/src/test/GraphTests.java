
import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class GraphTests {
    @Test
    @Score(1)
    public void sampleTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Graph g = new Graph();
            Node[] n = new Node[5];
            for(int i = 0; i < 5; i++)
            {
                n[i] = g.addNode();
            }
            g.addEdge(n[0], n[1], 3);
            g.addEdge(n[1], n[2], 5);
            g.addEdge(n[3], n[4], 100);

            assertThat(g.shortestPathLength(n[0], n[2]), is(8));
            assertThat(g.shortestPathLength(n[3], n[4]), is(100));
            assertThat(g.areUVConnected(n[0], n[4]), is(false));
        });
    }
}
