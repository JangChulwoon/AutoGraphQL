package org.toy.til.refactoring.ch01

class Rental {

    Movie movie
    int daysRented

    Rental(Movie movie, int daysRented) {
        this.movie = movie
        this.daysRented = daysRented
    }
}
