package org.toy.til.tdd.asert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Assert {

    public static void assertThat(int actual, int expect) {
        if (expect != actual) {
            fail(actual, expect);
        }
        success();
    }

    public static void assertThat(Double actual, Double expect) {
        if (actual.compareTo(expect) != 0) {
            fail(actual, expect);
        }
        success();
    }

    public static void assertThat(Long actual, Long expect) {
        if (actual.compareTo(expect) != 0) {
            fail(actual, expect);
        }
        success();
    }


    private static void success() {
        log.info("Success");
    }

    private static void fail(Object actual, Object expect) throws NotEqualsException {
        throw new NotEqualsException(String.format("expect : %s  actual : %s", actual.toString(), expect.toString()));
    }


    public static class NotEqualsException extends Error {
        public NotEqualsException(String message) {
            super(message);
        }
    }
}