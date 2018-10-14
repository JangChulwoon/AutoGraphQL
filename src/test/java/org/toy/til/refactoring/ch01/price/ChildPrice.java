package org.toy.til.refactoring.ch01.price;

class ChildPrice extends Price {

    @Override
    public double getCharge(int dayRental) {
        double thisAmount = 1.5;
        if (dayRental > 3) {
            thisAmount += (dayRental - 3) * 1.5;
        }
        return thisAmount;
    }

}
