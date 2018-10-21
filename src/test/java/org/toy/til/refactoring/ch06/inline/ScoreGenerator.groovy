package org.toy.til.refactoring.ch06.inline

class ScoreGenerator {

    // 만약 재정의 된 함수라면 inline method 를 실시하진말자.
    def calculate(rating) {
        return rating > 5 ? 1 : 2;
    }

}