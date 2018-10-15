package org.toy.til.groovy

import org.spockframework.runtime.SpockAssertionError
import spock.lang.FailsWith
import spock.lang.Shared
import spock.lang.Specification

// class name convention is (word)Specification
//@Stepwise  // if some TC fail, another TC don't operate.
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

    def "non shard variable TC1"() {
        given:
        nonSharedNum = 0
        println System.getProperty("spock.configuration");

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

}
// TODO ::  Arrange the spock and  use the spock to study other something.