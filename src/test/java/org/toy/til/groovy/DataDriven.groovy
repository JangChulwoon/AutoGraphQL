package org.toy.til.groovy

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class DataDriven extends Specification {

    def "maximum of two numbers step01"() {
        expect:
        // exercise math method for a few different inputs
        Math.max(1, 3) == 3
        Math.max(7, 4) == 7
        Math.max(0, 0) == 0
    }

    @Unroll
    def "maximum of two numbers step02"() {
        expect:
        // exercise math method for a few different inputs
        Math.max(a, b) == c

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }

    // 이게 된다고 ?? ㅋㅋㅋㅋㅋ
    @Unroll
    def "maximum of #a and #b is #c"() {
        expect:
        // exercise math method for a few different inputs
        Math.max(a, b) == c

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }

    @Shared
            sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    // DB에서 Data를 들고와서 검증 가능 ..  좋네
    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        [a, b, c] << sql.rows("select a, b, c from maxdata")
    }

}
