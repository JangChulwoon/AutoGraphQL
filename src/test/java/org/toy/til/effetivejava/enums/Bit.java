package org.toy.til.effetivejava.enums;

import org.junit.Test;

public class Bit {

    @Test
    public void bitTest() {
        int first = 10 << 1;
        int second = 5 << 2;

        System.out.println(String.format("f %d s %d", first, second));
        System.out.println(first | second);
    }
}
