import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class PostfixCalculatorTests {
    @Test
    @Score(1)
    public void test() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IPostfixCalculator p = new PostfixCalculator();
            assertThat(p.evaluate("5 10 4 x +"), is(45));
        });
    }
}
