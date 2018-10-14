package org.toy.til.refactoring.ch01.price;

public class NewReleasePrice extends Price {
    @Override
    public double getCharge(int dayRental) {
        return dayRental * 3;
    }

    @Override
    public int getPoints(int dayRental) {
        return dayRental > 1 ? 2 : 1;
    }
}
