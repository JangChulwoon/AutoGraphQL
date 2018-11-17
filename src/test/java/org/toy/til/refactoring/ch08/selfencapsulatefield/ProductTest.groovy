package org.toy.til.refactoring.ch08.selfencapsulatefield

import spock.lang.Specification

class ProductTest extends Specification {

    def "할인된 가격"() {

        given:
        Product product = new Product()

        when:
        product.with {
            price = mockPrice
            count = mockCount
            discount = mockDiscount

        }

        then:
        product.getAmountPrice() == expectedValue

        where: "최대 50% 할인"
        mockPrice << [100]
        mockCount << [1]
        mockDiscount << [0.6]
        expectedValue << [50]

    }
}
