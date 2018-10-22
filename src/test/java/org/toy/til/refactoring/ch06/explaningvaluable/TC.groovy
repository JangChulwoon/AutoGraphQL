package org.toy.til.refactoring.ch06.explaningvaluable

import spock.lang.Specification

class TC extends Specification {


    def getPrice(double quantity, double itemPrice) {
        return quantity * itemPrice - Math.max(0, quantity - 500) * itemPrice * 0.05 + Math.min(quantity * itemPrice * 0.1, 100.0)
    }


    def "example"() {
        expect:
        verifyAll {
            getPrice(quantity, itemPrice) == price
        }
        where:
        quantity << [10.0, 50.0]
        itemPrice << [400.0, 1000.0]
        price << [4100.0, 50100.0]

    }
}
