package org.toy.til.refactoring.ch06.replace.tempwithquery

class Product {

    /*
    한번만 호출되는지를 확인해야한다. -> final

     */

    double getPrice(quantity, itemPrice) {
        return getBasePrice(quantity, itemPrice) * getDiscountFactor(quantity, itemPrice)
    }

    double getDiscountFactor(quantity, itemPrice) {
        if (getBasePrice(quantity, itemPrice) > 1000) {
            return 0.95
        } else {
            return 0.98
        }
    }

    double getBasePrice(quantity, itemPrice) {
        quantity * itemPrice
    }
}
