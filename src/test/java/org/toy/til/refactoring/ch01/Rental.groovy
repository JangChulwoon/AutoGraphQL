package org.toy.til.refactoring.ch01

class Rental {

    Movie movie
    int daysRented

    Rental(Movie movie, int daysRented) {
        this.movie = movie
        this.daysRented = daysRented
    }

    double getCharge() {
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

    int getPoints(Rental each) {

        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
            return 2
        }
        return 1;
    }
}
