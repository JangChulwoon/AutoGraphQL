package org.toy.til.reflection;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicProxyTest {

    @Test
    public void dynamicProxyTC(){

        Hello hello = (Hello) Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[]{Hello.class},
                new UppercaseHandler(new HelloTarget()));

        assertThat(hello.sayThankYou("Toby"),is("THANK YOU TOBY"));
        assertThat(hello.sayThankYou("Toby"),is("THANK YOU TOBY"));
        assertThat(hello.sayHi("Toby"),is("HI TOBY"));
        assertThat(hello.sayHello("Toby"),is("HELLO TOBY"));

    }
}
