package org.toy.til.refactoring.ch01

class Rental {

    Movie movie
    int daysRented

    Rental(Movie movie, int daysRented) {
        this.movie = movie
        this.daysRented = daysRented
    }

    double getCharge() {
        return movie.getCharge(daysRented)
    }

    int getPoints(Rental each) {
        return movie.getPoints(each);
    }
}
