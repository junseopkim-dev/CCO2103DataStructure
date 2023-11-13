
import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class CuckooHashTests {
    @Test
    @Score(1)
    public void sampleTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ICuckooHash c = new CuckooHash(0.5, 4, 4);
            HashParameter hprev, hnext;

            hprev = c.getParams();
            assertThat(c.contains(100), is(false));
            c.insert(100);
            c.insert(104);
            hnext = c.getParams();
            assertThat(c.contains(104), is(true));
            assertThat(c.contains(100), is(true));
            testEquality(hprev, hnext);
            c.insert(108);
            hnext = c.getParams();
            assertThat(hnext.N, is(not(hprev.N)));
        });
    }

    private void testEquality(HashParameter hprev, HashParameter hnext){
        assertThat(hprev.a1, is(hnext.a1));
        assertThat(hprev.a2, is(hnext.a2));
        assertThat(hprev.b1, is(hnext.b1));
        assertThat(hprev.b2, is(hnext.b2));
        assertThat(hprev.N, is(hnext.N));
    }
}
