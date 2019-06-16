package org.toy.til.reflection

import spock.lang.Specification

import java.lang.reflect.Proxy

class SimpleProxyTest extends Specification{

    def "hello ?"(){
        def hello = new HelloTarget();

        expect:
        hello.sayHello("Toby") == "Hello Toby"
        hello.sayHi("Toby") == "Hi Toby"
        hello.sayThankYou("Toby") == "Thank You Toby"
    }

    def "simple Proxy"(){
        // 이런형태의 proxy 는 중복 코드 및 관리 포인트의 증가 등의 문제를 갖고있다.
        def hello = new HelloUppercase(new HelloTarget())

        expect:
        hello.sayHello("Toby") == "HELLO TOBY"
        hello.sayHi("Toby") == "HI TOBY"
        hello.sayThankYou("Toby") == "THANK YOU TOBY"
    }


}
