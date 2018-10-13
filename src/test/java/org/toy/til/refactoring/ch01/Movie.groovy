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
}
