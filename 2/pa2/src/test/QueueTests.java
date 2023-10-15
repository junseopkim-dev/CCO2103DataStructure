import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class QueueTests {
    @Test
    @Score(1)
    public void test() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Queue<Integer> q = new Queue<>();

            q.enqueue(3);
            q.enqueue(4);
            assertThat(q.peek(), is(3));
            assertThat(q.dequeue(), is(3));
            assertThat(q.dequeue(), is(4));
        });
    }
}
