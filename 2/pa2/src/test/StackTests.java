import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class StackTests {
    @Test
    @Score(1)
    public void test() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Stack<Integer> s = new Stack<>();

            s.push(3);
            s.push(4);
            assertThat(s.peek(), is(4));
            assertThat(s.pop(), is(4));
            assertThat(s.pop(), is(3));
        });
    }
}
