package org.toy.til.refactoring.ch04

import spock.lang.Specification

class Refactoring04 extends Specification {

    FileReader input;

    def setup() {
        input = new FileReader("data.txt")
    }


    def "4번째 단어 읽기"() {
        given:
        def word = '&'

        when:
        for (def i = 0; i < 4; ++i) {
            word = input.read()
        }

        then:
        word == 'd'
    }

    def cleanup() {
        input.close()
    }
}
