package org.toy.til.refactoring.ch06.inline

class ScoreGenerator {


    def calculate(rating) {
        return rating > 5 ? 1 : 2;
    }

}