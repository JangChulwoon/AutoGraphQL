package org.toy.til.refactoring.ch01.price

abstract class Price {
    abstract double getCharge(int dayRental)

    int getPoints(int dayRental) {
        return 1;
    }
}
