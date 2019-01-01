package org.toy.til.effective;

import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Parallel {

    private final static BigInteger TWO = BigInteger.valueOf(2);

    private static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    @Test()
    public void test_nonparallel() {
        primes().map(p -> TWO.pow(p.intValue()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(1))
                .limit(20)
                .forEach(System.out::println);
    }

    @Test
    // 안돈다
    public void test_parallel() {
        primes().parallel()
                .map(p -> TWO.pow(p.intValue()).subtract(BigInteger.ONE))
                .filter(mersenne -> {
                    if (mersenne.isProbablePrime(1)) {
                        System.out.println(Thread.currentThread().getName() + " : " + mersenne);
                    }

                    return mersenne.isProbablePrime(1);
                })
                .limit(20)
                .forEach(System.out::println);
    }
}
