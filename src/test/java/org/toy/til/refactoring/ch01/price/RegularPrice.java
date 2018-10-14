package org.toy.til.refactoring.ch01.price;

public class RegularPrice extends Price {
    @Override
    public double getCharge(int dayRental) {
        double thisAmount = 2;
        if (dayRental > 2) {
            thisAmount += (dayRental - 2) * 1.5;
        }
        return thisAmount;
    }
}
