package org.toy.til.presentation.chap06.replacetempwithquery

import spock.lang.Specification

class TC extends Specification {

    def "된다 !! "() {
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
