package org.toy.til.refactoring.ch01

class Movie {
    static final int CHILD_RENS = 2
    static final int REGULAR = 0
    static final int NEW_RELEASE = 0

    String title
    int priceCode

    Movie(title, priceCode) {
        this.title = title
        this.priceCode = priceCode
    }


    double getCharge(int dayRental) {
        double thisAmount = 0
        switch (this.getPriceCode()) {
            case REGULAR:
                thisAmount += 2
                if (dayRental > 2) {
                    thisAmount += (dayRental - 2) * 15
                }
                break
            case NEW_RELEASE:
                thisAmount += dayRental * 3
                break
            case CHILD_RENS:
                thisAmount += 1.5
                if (dayRental > 3) {
                    thisAmount += (dayRental - 3) * 1.5
                }
                break;
        }
        return thisAmount
    }
}
