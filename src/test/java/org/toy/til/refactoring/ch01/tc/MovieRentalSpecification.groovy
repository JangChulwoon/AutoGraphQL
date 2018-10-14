package org.toy.til.refactoring.ch01.tc

import org.junit.Ignore
import org.toy.til.refactoring.ch01.Customer
import org.toy.til.refactoring.ch01.Movie
import org.toy.til.refactoring.ch01.Rental
import spock.lang.Specification

class MovieRentalSpecification extends Specification {

    def name = "jangChulwoon";

    @Ignore
    def "confirm message"() {
        given:
        def customer = new Customer(name)
        def movie = new Movie("Refactoring", 2)
        def rental = new Rental(movie, 3)

        when:
        customer.addRental(rental)
        def massage = customer.statement()

        then:
        massage

    }


    def "When Movie type is regular"() {
        given:
        def movie = new Movie("Regular", 0)

        expect:
        movie.getCharge(dayRental) == charge

        where:
        dayRental | charge
        2         | 2
        3         | 3.5
    }

    def "When Movie type is new release"() {
        given:
        def movie = new Movie("NEW_RELEASE", 1)

        expect:
        movie.getCharge(dayRental) == charge

        where:
        dayRental | charge
        2         | 6
        3         | 9
    }

    def "When Movie type is child"() {
        given:
        def movie = new Movie("CHILD_RENS", 2)

        expect:
        movie.getCharge(dayRental) == charge

        where:
        dayRental | charge
        3         | 1.5
        4         | 3

    }

}
