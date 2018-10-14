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

}
