package org.toy.til.refactoring.ch08.selfencapsulatefield;

public class Cloth extends Product {

    public static final double LIMIT_RATE = 0.4;

    @Override
    public double getDiscount() {
        if (super.getDiscount() > LIMIT_RATE) {
            return LIMIT_RATE;
        }
        return super.getDiscount();
    }
}
