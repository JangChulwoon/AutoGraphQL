package org.toy.til.refactoring.ch06.replace.tempwithquery


import spock.lang.Specification

class TC extends Specification {

    def "test getPrice"() {
        given:
        Product product = new Product()

        expect:
        product.getPrice(quantity, itemPrice) == result

        where:
        quantity << [4, 500]
        itemPrice << [10, 10]
        result << [39.2, 4750]
    }
}
