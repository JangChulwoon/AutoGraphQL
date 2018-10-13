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

        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
            return 2
        }
        return 1;
    }
}
