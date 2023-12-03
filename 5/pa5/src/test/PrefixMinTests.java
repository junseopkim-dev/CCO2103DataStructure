
import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class PrefixMinTests {
//    @Test
//    @Score(1)
//    public void sampleTest() {
//        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
//            PrefixMin pm = new PrefixMin();
//
//            YonseiString s1 = new YonseiString(new int[] {1,2,3,4,5,6});
//            YonseiString s2 = new YonseiString(new int[] {1,2,3,3,3,3});
//            YonseiString s3 = new YonseiString(new int[] {3,3,3,3,3,3});
//            YonseiString s4 = new YonseiString(new int[] {1,2,3});
//
//            pm.insert(s1,5);
//            pm.insert(s2,10);
//            pm.insert(s1,4);
//            pm.insert(s3,1);
//            assertThat(pm.getMin(s4), is(5));
//        });
//    }

//    @Test
//    @Score(1)
//    public void emptyTest() {
//        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
//            PrefixMin prefixMin = new PrefixMin();
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {2, 3, 1, 2, 4})), is(Integer.MIN_VALUE));
//        });
//    }
//
//    @Test
//    @Score(2)
//    public void getMinTest() {
//        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
//            PrefixMin prefixMin = new PrefixMin();
//            prefixMin.insert(new YonseiString(new int[] {1, 2, 3}), 10);
//            prefixMin.insert(new YonseiString(new int[] {1, 2, 3, 5}), 1);
//            prefixMin.insert(new YonseiString(new int[] {1, 2, 3, 4}), 2);
//            prefixMin.insert(new YonseiString(new int[] {1, 2, 3, 6}), 3);
//            prefixMin.insert(new YonseiString(new int[] {1, 2, 3, 7}), 4);
//            prefixMin.insert(new YonseiString(new int[] {1, 2, 3, 7, 8}), 3);
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 5})), is(1));
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 4})), is(2));
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 6})), is(3));
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 7})), is(4));
//            assertThat(prefixMin.getMin(new YonseiString(new int[] {1, 2})), is(1));
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3})), is(10));
//            assertThat(prefixMin.getMin(new YonseiString(new int[] {1, 2, 3, 7})), is(3));
//            prefixMin.remove(new YonseiString(new int[] {1, 2, 3}));
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3})), is(Integer.MIN_VALUE));
//            prefixMin.remove(new YonseiString(new int[] {1, 2, 3, 7, 8}));
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 5})), is(1));
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 4})), is(2));
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 6})), is(3));
//            assertThat(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 7})), is(4));
//        });
//    }

    @Test
    @Score(1)
    public void Test1() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            PrefixMin prefixMin = new PrefixMin();
            YonseiString s1 = new YonseiString(new int[] {'a', 'b', 'c', 'd', 'e', 'f'});
            YonseiString s2 = new YonseiString(new int[] {'a', 'b', 'c', 'c', 'c', 'c'});
            YonseiString s3 = new YonseiString(new int[] {'c', 'c', 'c', 'c', 'c', 'c'});
            YonseiString s4 = new YonseiString(new int[] {'a', 'b', 'c'});

            prefixMin.insert(s1, 5);
            prefixMin.insert(s2, 10);
            prefixMin.insert(s1, 4);
            prefixMin.insert(s3, 1);

            assertThat(prefixMin.getMin(s4), is(5));

            prefixMin.remove(s1);
            assertThat(prefixMin.getMin(s4), is(10));

        });
    }

    @Test
    @Score(1)
    public void Test2() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            PrefixMin prefixMin = new PrefixMin();
            YonseiString s1 = new YonseiString(new int[] {'m', 'i', 's', 's', 'i', 's', 's', 'i', 'p', 'p', 'i'});
            YonseiString s2 = new YonseiString(new int[] {'m','i', 's','s'});
            YonseiString s3 = new YonseiString(new int[] {'m','i', 's','s','i','n','g'});
            YonseiString s4 = new YonseiString(new int[] {'m'});
            YonseiString s5 = new YonseiString(new int[] {'m','i', 's', 's', 'i'});
            YonseiString s6 = new YonseiString(new int[] {'m','i', 's'});

            prefixMin.insert(s1, 5);
            prefixMin.insert(s2, 10);
            prefixMin.insert(s1, 4);
            prefixMin.insert(s3, 1);
            prefixMin.insert(s5, 3);
            prefixMin.insert(s6, 2);

            assertThat(prefixMin.getMin(s4), is(1));
            assertThat(prefixMin.getMin(s5), is(1));
            assertThat(prefixMin.getValue(s5), is(3));

            prefixMin.remove(s3);

            assertThat(prefixMin.getMin(s4), is(2));
            assertThat(prefixMin.getMin(s2), is(3));
        });
    }

    @Test
    @Score(1)
    public void Test3() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            PrefixMin prefixMin = new PrefixMin();
            YonseiString s1 = new YonseiString(new int[] {'Y', 'o', 'n', 's', 'e', 'i'});
            YonseiString s2 = new YonseiString(new int[] {'Y', 'o', 'n', 's', 'e', 'i', 'U', 'n', 'i', 'v', 'e', 'r', 's', 'i', 't', 'y'});
            YonseiString s3 = new YonseiString(new int[] {'Y', 'o', 'n', 's', 'e', 'i', 'U', 'n', 'i', 'v', 'e', 'r', 's', 'i', 't', 'y', 'S', 't', 'u', 'd', 'e', 'n', 't'});
            YonseiString s4 = new YonseiString(new int[] {'Y', 'o', 'n', 's', 'e', 'i', 'U', 'n', 'i', 'v', 'e', 'r', 's', 'i', 't', 'y', 'S', 't', 'u', 'd', 'e', 'n', 't', 'C', 'l', 'u', 'b'});
            YonseiString p1 = new YonseiString(new int[] {'T','i','r','e','d'});


            prefixMin.insert(s4, 3);
            prefixMin.insert(s2, 6);
            prefixMin.insert(s1, 1);
            prefixMin.insert(s3, 2);

            assertThat(prefixMin.getMin(s1), is(1));
            assertThat(prefixMin.getMin(s2), is(2));
            assertThat(prefixMin.getMin(p1), is(Integer.MIN_VALUE));

            prefixMin.remove(s3);

            assertThat(prefixMin.getMin(s2), is(3));
            assertThat(prefixMin.getValue(s4), is(3));
            assertThat(prefixMin.getValue(p1), is(Integer.MIN_VALUE));

        });
    }

}

//

