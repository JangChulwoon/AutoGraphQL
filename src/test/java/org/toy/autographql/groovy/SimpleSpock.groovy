package org.toy.autographql.groovy

import spock.lang.Specification

class SimpleSpock extends Specification {
    def "SimpleSpockTest"() {
        expect:
        name.size() == length

        where:
        name    | length
        "Spock" | 5
        "Fizz"  | 4
    }
}