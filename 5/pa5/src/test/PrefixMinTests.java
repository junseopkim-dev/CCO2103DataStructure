
import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class PrefixMinTests {
    @Test
    @Score(1)
    public void sampleTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            PrefixMin pm = new PrefixMin();

            YonseiString s1 = new YonseiString(new int[] {1,2,3,4,5,6});
            YonseiString s2 = new YonseiString(new int[] {1,2,3,3,3,3});
            YonseiString s3 = new YonseiString(new int[] {3,3,3,3,3,3});
            YonseiString s4 = new YonseiString(new int[] {1,2,3});

            pm.insert(s1,5);
            pm.insert(s2,10);
            pm.insert(s1,4);
            pm.insert(s3,1);
            assertThat(pm.getMin(s4), is(5));
        });
    }
}
