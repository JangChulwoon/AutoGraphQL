package org.toy.til.refactoring.ch01.tc

import org.toy.til.refactoring.ch01.Customer
import org.toy.til.refactoring.ch01.Movie
import org.toy.til.refactoring.ch01.Rental
import org.toy.til.refactoring.ch01.price.ChildPrice
import org.toy.til.refactoring.ch01.price.NewReleasePrice
import org.toy.til.refactoring.ch01.price.RegularPrice
import spock.lang.Ignore
import spock.lang.Specification

class MovieRentalSpecification extends Specification {

    def name = "jangChulwoon";

    @Ignore
    def "confirm message"() {
        given:
        def customer = new Customer(name)
        def movie = new Movie("Refactoring", new RegularPrice())
        def rental = new Rental(movie, 3)

        when:
        customer.addRental(rental)
        def massage = customer.statement()
        // print(massage)

        then:
        massage

    }


    def "When Movie type is regular"() {
        given:
        def movie = new Movie("Regular", new RegularPrice())

        expect:
        movie.getCharge(dayRental) == charge

        where:
        dayRental | charge
        2         | 2
        3         | 3.5
    }

    def "When Movie type is new release"() {
        given:
        def movie = new Movie("NEW_RELEASE", new NewReleasePrice())

        expect:
        movie.getCharge(dayRental) == charge

        where:
        dayRental | charge
        2         | 6
        3         | 9
    }

    def "When Movie type is child"() {
        given:
        def movie = new Movie("CHILD_RENS", new ChildPrice())

        expect:
        movie.getCharge(dayRental) == charge

        where:
        dayRental | charge
        3         | 1.5
        4         | 3

    }

}
