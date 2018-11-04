package org.toy.til.groovy

import org.junit.Ignore
import org.spockframework.runtime.SpockAssertionError
import spock.lang.*

// class name convention is (word)Specification
@Stepwise
// if some TC fail, another TC don't operate. + not override ignore / ignoreIf / IgnoreRest
//@Timeout(2) 각 블럭마다 2초, 만약 메서드 위에 선언되면 걔를 우선으로 ...
class SimpleSpock extends Specification {

    /**
     * if don't use @shared, the Variable is not shared.
     * In a nutshell, Methods don't share the **nonShared** Variable.
     *
     * Comment ..
     * setupSpec() and cleanupSpec() -> shared variable
     * setup() and cleanup() -> none shared variable
     *
     */

    /**
     * if sub Class implement the setUp Method, First, It is call super cleanup Method. and then, execute sub method.
     * cleanup is reverse.
     *
     * setupSpec / cleanupSpec same.
     * so we do not sentences  such as `super.cleanup()`.
     */


    @Shared
    def sharedNum = 4
    def nonSharedNum = 4

    @Ignore
    def "non shard variable TC1"() {
        given:
        nonSharedNum = 0

        expect:
        nonSharedNum == 0
    }

    def "non shard variable TC2"() {
        expect:
        nonSharedNum == 4
    }


    def "shard variable TC1"() {
        given:
        sharedNum = 0

        expect:
        sharedNum == 0
    }

    @Timeout(1)
    def "1shard variable TC2"() {

        expect:
        a == 1
        where:
        a << [fixture(), fixture()]
    }

    def fixture() {
        Thread.sleep(1500)
        1
    }

    def "shard variable TC2"() {
        expect:
        asa == o
    }

    /**
     * Annotation Comment
     *
     * @IgnoreRest - except this method to ignore other methods
     * @Ignore - method or specification ignore
     * @FailsWith ( E r r o r T y p e ) - Failure in the specified Type
     */

    def "when then example"() {

        given:
        def multiplier = 2

        expect:
        square == Math.pow(origin, multiplier)

        where:
        origin | square
        4      | 16
        13     | 169
        15     | 225
    }

    def "expect example"() {

        given:
        def multiplier = 2

        expect:
        square == Math.pow(origin, multiplier)

        where:
        origin | square
        4      | 16
        13     | 169
        15     | 225
    }

    def "cleanup and where blcok"() {
        Socket con = new Socket()

        expect: "you can write about block' explanation"
        a != b

        cleanup: "cleanup is locate before where block. It is free memory"
        con.close()

        where: "where block can help data injection! first a = 2, b = 4 and a = 4 , b = 5 "
        a | b
        2 | 4
        4 | 5

    }

    // don't use helper Method.
    // just use fixture.

    @FailsWith(SpockAssertionError)
    def "wrong case fixture method"() {

        given:
        def name = "chulwoon"
        def age = 25
        def address = "yongIn"

        expect:
        fixtureMethod(name, age, address) // wrong case

    }

    def fixtureMethod(name, age, address) {
        name == "Jang" && address == "yong-In" && age == 24
    }

    /**
     * this case show elegant log.
     * but if fixture method return value, It is failing condition which is not what we want.
     * so Spock recommend to use Helper Method.
     *
     * Plus, helper methods can increase the coupling between feature methods.
     *
     */
    @FailsWith(SpockAssertionError)
    def "wrong case_2 fixture method"() {

        def name = "chulwoon"
        def age = 25
        def address = "yongIn"

        expect: "use assert !"
        fixtureMethod2(name, age, address)


    }

    void fixtureMethod2(name, age, address) {
        assert name == "chulwoon"
        assert address == "yongIn"
        assert age == 24
    }


    class People {
        def name
        def address
        def age

        People() {
        }

        People(name, address, age) {
            this.name = name
            this.address = address
            this.age = age
        }
    }

    // It is helper Method :D

    def "with statement"() {

        when:
        def people = new People("Jang", "yong-In", 25)

        then: "we don't use assert keyword !! Just use block with ( value ) {} "

        with(people) {
            name == "Jang"
            address == "yong-In"
            age == 25
        }
    }

    /**
     * verifyAll Helper is all check condition even if condition fail.
     */
    @FailsWith(SpockAssertionError)
    def "verifyAll statement"() {
        def people = new People()

        people.with { // lol ...
            name = "Jang"
            address == "yong-In"
            age == 25
        }

        expect: "we don't use assert keyword !! Just use block with ( value ) {} "
        with(people) {
            verifyAll {
                name == "Jang"
                address == "yong-In"
                age == 25
            }
        }
    }

    // static value / static method  만 가능
    static def condition = true;

    @IgnoreIf({ SimpleSpock.condition })
    def "I'll run everywhere but on MAC"() {

        expect:
        "1" == "1"


    }

    @Requires({ System.getProperty("os.name").contains("Mac OS X") })
    def "I'll run MAC"() {

        expect:
        "1" == "1"


    }

    @PendingFeature
    def "not implemented yet"() {

        expect:
        1 == 0
        2 == 0


    }

    @Timeout(5)
    def "5초 이상 걸리면 실패"() {

        Thread.sleep(5000);

        expect:
        1 == 1


    }

}
// TODO ::  Arrange the spock and  use the spock to study other something.