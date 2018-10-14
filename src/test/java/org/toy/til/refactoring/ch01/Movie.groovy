package org.toy.til.refactoring.ch01

import org.toy.til.refactoring.ch01.price.Price

class Movie {

    String title
    Price price

    Movie(title, Price price) {
        this.title = title
        this.price = price
    }

    double getCharge(int dayRental) {
        return price.getCharge(dayRental)
    }

    int getPoints(int dayRental) {
        return price.getPoints(dayRental)
    }
}
