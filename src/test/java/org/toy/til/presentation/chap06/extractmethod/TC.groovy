package org.toy.til.presentation.chap06.extractmethod

import spock.lang.Specification

class TC extends Specification {


    def "출력 확인"() {
        given:
        def order = new Order();
        def orderList = [new Order(price: 4000), new Order(price: 5000)]

        expect:
        order.printOwing(orderList)
    }
}
