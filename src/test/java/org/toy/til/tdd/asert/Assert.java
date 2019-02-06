package org.toy.til.tdd.asert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Assert {

    public static <T> void assertThat(T actual, T expect) {
        if (!actual.equals(expect)) {
            fail(actual, expect);
        }
        success();
    }


    private static void success() {
        log.info("Success");
    }

    private static void fail(Object actual, Object expect) {
        throw new NotEqualsException(String.format("expect : %s  actual : %s", actual.toString(), expect.toString()));
    }

    public static class NotEqualsException extends RuntimeException {
        public NotEqualsException(String message) {
            super(message);
        }
    }
}