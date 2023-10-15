import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class PostfixCalculatorTests {
    @Test
    @Score(1)
    public void test1() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IPostfixCalculator p = new PostfixCalculator();
            assertThat(p.evaluate("5 10 4 x +"), is(45));
        });
    }

    @Test
    @Score(1)
    public void test2() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IPostfixCalculator p = new PostfixCalculator();
            assertThat(p.evaluate("10 3 - 2 x"), is(14));
        });
    }

    @Test
    @Score(1)
    public void test3() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IPostfixCalculator p = new PostfixCalculator();
            assertThat(p.evaluate("10 3 2 x -"), is(4));
        });
    }
}
