
import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class BinarySearchTreeTests {
    @Test
    @Score(1)
    public void sampleTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IBinarySearchTree<Integer> b = new BinarySearchTree<>();
            b.put(5);
            b.put(2);
            b.put(7);
            assertThat(b.contains(2), is(true));
            assertThat(b.contains(3), is(false));
            assertThat(b.getNext(3), is(5));
            b.remove(5);
            assertThat(b.contains(5), is(false));
        });
    }
}
