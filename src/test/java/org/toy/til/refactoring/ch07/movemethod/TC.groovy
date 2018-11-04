package org.toy.til.refactoring.ch07.movemethod

import spock.lang.Specification

class TC extends Specification {

    /*
    클래스가 다른 클래스와 과하게 연동되어 의존성이 지나칠 경우, 메서드 이동을 한다.
    DAO / Service Layer 관계에 대해 생각해봤는데
    만약 Service Layer 의 함수가 과다하게 DAO를 본다면
    그 함수를 DAO 로 이동시키고 결과를 받는 함수를 만드는게 좋겠다는 생각을 함. :+1

     */

    def "메서드 이동"() {
        given:
        def account = new Account(type: new AccountType(), daysOverdrawn: daysOverdrawn)

        expect:
        verifyAll {
            account.bankCharge() == result
        }

        where:
        daysOverdrawn << [6, 7, 8]
        result << [14.5, 14.5, 15.35]

    }
}
