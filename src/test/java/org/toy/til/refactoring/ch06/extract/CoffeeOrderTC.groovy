package org.toy.til.refactoring.ch06.extract

import spock.lang.Specification

class CoffeeOrderTC extends Specification {

    def "커피 주문"() {
        given:
        POSMachine posMachine = new POSMachine()
        List<Order> coffee = [new Order("Long-Black", 3000), new Order("Latte", 4500), new Order("Espresso", 1000)]

        expect:
        posMachine.printOwing(coffee)

    }

}
