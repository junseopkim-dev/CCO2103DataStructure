
import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class HeapTests {
    @Test
    @Score(1)
    public void sampleTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IHeap<Integer> heap = new Heap<>();

            heap.insert(2);
            heap.insert(3);
            heap.insert(1);
            assertThat(heap.removeMin(), is(1));

            IHeap<Integer> heap2 = new Heap<>();
            heap2.insert(0);
            heap2.insert(4);

            heap.merge(heap2);

            assertThat(heap.removeMin(), is(0));
        });
    }
}
