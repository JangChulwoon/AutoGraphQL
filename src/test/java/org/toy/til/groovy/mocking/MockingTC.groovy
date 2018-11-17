package org.toy.til.groovy.mocking

import spock.lang.Specification

class MockingTC extends Specification {

    def "should send messages to all subscribers"() {
        // ...
        Discount discount = new Discount();
        Product product = new Product(1000, discount)
        when:
        product.getPrice(count)
        then:
        1 * discount.getDiscount(count)
        where:
        count << [10, 20]
    }

    // interaction 확인

    class Product {

        def price;
        Discount discount

        Product(price, discount) {
            this.price = price
            this.discount = discount
        }

        def getPrice(count) {
            return price * discount.getDiscount(count)
        }
    }

    class Discount {
        def getDiscount(count) {
            count > 5 ? 0.1 : 1
        }
    }

}
