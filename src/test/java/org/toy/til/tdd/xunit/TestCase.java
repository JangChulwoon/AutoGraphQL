package org.toy.til.tdd.xunit;

// https://jojoldu.tistory.com/231

public class TestCase {

    public static void main(String[] args) {
        int expect = 11;
        int actual = 10;

        Assert.assertThat(expect, actual);
    }

    static class Assert {

        public static void assertThat(int expect, int actual) {
            if (expect != actual) {
                throw new RuntimeException(String.format("expect : %d  actual : %d", expect, actual));
            }
            System.out.println("success");
        }
    }
}


