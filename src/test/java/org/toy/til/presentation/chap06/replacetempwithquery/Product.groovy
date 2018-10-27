package org.toy.til.presentation.chap06.replacetempwithquery

class Product {


    def getPrice(quantity, itemPrice) {
        def basePrice = quantity * itemPrice
        double discountFactor;
        if (basePrice > 1000) {
            discountFactor = 0.95
        } else {
            discountFactor = 0.98
        }
        return discountFactor * basePrice

    }
}
