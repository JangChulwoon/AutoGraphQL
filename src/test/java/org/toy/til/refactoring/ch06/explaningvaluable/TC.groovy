package org.toy.til.refactoring.ch06.explaningvaluable

import spock.lang.Specification

class TC extends Specification {

    // using explaining variable
    def getPrice(double quantity, double itemPrice) {
        def basePrice = quantity * itemPrice
        def discountPrice = Math.max(0, quantity - 500) * itemPrice * 0.05
        def shippingPrice = Math.min(basePrice * 0.1, 100.0)
        return basePrice - discountPrice + shippingPrice
    }

    // using extract method !
    // this can approach from the other method of object.
    def getPrice_extractMethod(double quantity, double itemPrice) {
        return getBasePrice(quantity, itemPrice) - getDiscountPrice(quantity, itemPrice) + getShippingPrice(quantity, itemPrice)
    }

    private double getShippingPrice(double quantity, double itemPrice) {
        Math.min(getBasePrice(quantity, itemPrice) * 0.1, 100.0)
    }

    private double getDiscountPrice(double quantity, double itemPrice) {
        Math.max(0, quantity - 500) * itemPrice * 0.05
    }

    private double getBasePrice(double quantity, double itemPrice) {
        quantity * itemPrice
    }


    def "example"() {
        expect:
        verifyAll {
            getPrice(quantity, itemPrice) == price
            getPrice_extractMethod(quantity, itemPrice) == price
        }
        where:
        quantity << [10.0, 50.0]
        itemPrice << [400.0, 1000.0]
        price << [4100.0, 50100.0]

    }
}
