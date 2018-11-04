package org.toy.til.presentation.chap06.replacetempwithquery

class Product {

    def getPrice(quantity, itemPrice) {
        return getDiscountFactor(quantity, itemPrice) * getBasePrice(quantity, itemPrice)
    }

    private getDiscountFactor(quantity, itemPrice) {
        if (getBasePrice(quantity, itemPrice) > 1000) {
            return 0.95
        } else {
            return 0.98
        }
    }

    private getBasePrice(quantity, itemPrice) {
        quantity * itemPrice
    }
}
