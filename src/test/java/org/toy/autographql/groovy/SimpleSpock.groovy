package org.toy.autographql.groovy

import spock.lang.Shared
import spock.lang.Specification

// class 이름은 명세나 스펙과 관련되어 있는 이름 ..  Ex MyFirstSpecification
class SimpleSpock extends Specification {

    // Shared를 안붙이면 setUp과 동일하게 동작한다.
    @Shared
    def num = 4
    // def num = 4;

    // setupSpec or cleanupSpec -> shared
    // 일반 애들 setup() and cleanup()

    // if setUp 을 구현한 하위 클래스가 있으면, super -> sub
    // cleanup 은 반대. 서브 -> 슈퍼
    // setupSpec / cleanupSpec 도 동일하게 행동 때문에 super.setUp() 같은 짓을 할필요 없음

    def "SimpleSpockTest"() {

        expect:
        name.size() == length

        where:
        name    | length
        "Spock" | 5
        "Fizz"  | 4
    }

    def "numTest"() {

        expect:
        name.size() == length

        where:
        name    | length
        "Spock" | 5
        "Fizz"  | 4
    }
}