package org.toy.til.refactoring.ch08.selfencapsulatefield

import spock.lang.Specification

class ClothTest extends Specification {


    def "할인된 가격"() {

        given:
        Product product = new Cloth()

        when:
        product.with {
            price = mockPrice
            count = mockCount
            discount = mockDiscount

        }

        then:
        product.getAmountPrice() == expectedValue

        where: "최대 40% 할인"
        mockPrice << [100]
        mockCount << [1]
        mockDiscount << [0.6]
        expectedValue << [60]

    }
}
