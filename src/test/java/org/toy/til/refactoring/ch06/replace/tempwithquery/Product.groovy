package org.toy.til.refactoring.ch06.replace.tempwithquery

class Product {

    double getPrice(quantity, itemprice) {
        int basePrice = quantity * itemprice
        double discountFactor;

        if (basePrice > 1000) {
            discountFactor = 0.95
        } else {
            discountFactor = 0.98
        }
        return basePrice * discountFactor
    }
}
