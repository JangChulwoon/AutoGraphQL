package org.toy.autographql.groovy

import spock.lang.Shared
import spock.lang.Specification

class People {
    private String name;
    private String address;
    private int age;

    People(String name, String address, int age) {
        this.name = name
        this.address = address
        this.age = age
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getAddress() {
        return address
    }

    void setAddress(String address) {
        this.address = address
    }

    int getAge() {
        return age
    }

    void setAge(int age) {
        this.age = age
    }
}

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

    // helper method

    def "wrong case fixture method"() {

        when:
        def people = new People("Jang", "yong-In", 25);

        then:
        fixtureMethod(people) // wrong case

    }

    def fixtureMethod(people) {
        people.name == "Jang" && people.address == "yong-In" && people.age == 25
    }

    def "wrong case_2(?) fixture method"() {

        when:
        def people = new People("Jang", "yong-In", 25);

        then:
        fixtureMethod2(people) // wrong case

    }
/**
 * first. 계속 assert 를 써야함.
 * second. method가 void 로 선언되어야함.
 * 만약 마지막/ 중간에 false를 리턴하면 테스트도 깨진다.
 * 선호 되지는 않네 ..?
 * @param people
 */
    def fixtureMethod2(people) {
        assert people.name == "Jang"
        assert people.address == "yong-In"
        assert people.age == 25
        // false
    }
/**
 * Fixture method 나 helper method는 피해야함.
 * 한가지 변화에 대해 2개 이상의 TC가 변경될 수 있기때문
 * 결합도도 심하고 ...
 */


    def "with statement"() {

        when:
        def people = new People("Jang", "yong-In", 25);

        then:
        with(people) {
            name == "Jang"
            address == "yong-In"
            age == 25
        }

    }
/**
 * with 는 하나라도 실패하면 아래 문장을 실행하지 않음.
 * verifyAll 는 모두 다 검사함. 실패해도 다음것을 검사. 
 */
    def "verifyAll statement"() {

        given:
        def people = new People("Jang", "yong-In", 25)

        expect:
        with(people) {
            verifyAll {
                name == "Jang1"
                address == "yong-In"
                age == 24
            }
        }

    }

}