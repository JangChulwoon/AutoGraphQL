package org.toy.til.tdd.asert;

// https://jojoldu.tistory.com/231

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestCase {

    @Test
    public void primitiveTest() {

        Assert.assertThat(10 + 10, 20);
        Assert.assertThat(Double.valueOf("10") + Double.valueOf("20"), Double.valueOf("30"));

    }


    @Test(expected = RuntimeException.class)
    public void wrongPrimitiveTest() {

        Assert.assertThat(11 + 10, 20);
        Assert.assertThat(Double.valueOf("11") + Double.valueOf("20"), Double.valueOf("30"));

    }

    static class Assert {

        public static void assertThat(int actual, int expect) {
            if (expect != actual) {
                throw new RuntimeException(String.format("expect : %d  actual : %d", expect, actual));
            }
            log.info("Success");
        }

        public static void assertThat(Double actual, Double expect) {
            if (actual.compareTo(expect) != 0) {
                throw new RuntimeException(String.format("expect : %f  actual : %f", expect, actual));
            }
            log.info("Success");
        }


    }
}


