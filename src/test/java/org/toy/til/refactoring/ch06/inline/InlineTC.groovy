package org.toy.til.refactoring.ch06.inline

import spock.lang.Specification

class InlineTC extends Specification {

    def "More Than Five Rating TC"() {
        given:
        ScoreGenerator scoreGenerator = new ScoreGenerator();
        expect:
        scoreGenerator.calculate(rating) == expectedValue

        where:
        rating << [4, 6]
        expectedValue << [2, 1]

    }

}
