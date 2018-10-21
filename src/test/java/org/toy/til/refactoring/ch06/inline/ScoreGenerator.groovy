package org.toy.til.refactoring.ch06.inline

class ScoreGenerator {


    def calculate(rating) {
        return moreThanFiveRating(rating) ? 1 : 2;

    }

    private boolean moreThanFiveRating(rating) {
        rating > 5
    }
}