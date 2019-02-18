package org.toy.til.exceptionstudy;

import org.junit.Test;

public class ExceptionTest {

    @Test
    public void test() {
        try {
            sub();
        } catch (CustomException cus) {
            System.out.printf("heelo");
            // 이 친구를 handling 하려면 catch 문에 try-catch를 넣던가.
            // throws 를 넣어야함.
            // throw new SubException("?");
        }
    }

    private void sub() throws CustomException {
        // exception 도 상속 계층구조를 탐.
        throw new SubCustomException("first");
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

class SubCustomException extends CustomException {
    public SubCustomException(String message) {
        super(message);
    }
}




