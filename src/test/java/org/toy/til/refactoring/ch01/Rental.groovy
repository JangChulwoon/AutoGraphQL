package org.toy.til.refactoring.ch01

class Rental {

    Movie movie
    int daysRented

    Rental(Movie movie, int daysRented) {
        this.movie = movie
        this.daysRented = daysRented
    }

    private double getCharge() {
        double thisAmount = 0
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2
                if (this.getDaysRented() > 2) {
                    thisAmount += (this.getDaysRented() - 2) * 15
                }
                break
            case Movie.NEW_RELEASE:
                thisAmount += this.getDaysRented() * 3
                break
            case Movie.CHILD_RENS:
                thisAmount += 1.5
                if (this.getDaysRented() > 3) {
                    thisAmount += (this.getDaysRented() - 3) * 1.5
                }
                break;
        }
        return thisAmount
    }
}
