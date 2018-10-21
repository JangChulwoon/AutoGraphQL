package org.toy.til.refactoring.ch06

class POSMachine {

    void printOwing(List<Order> orderList) {

        def totalPrice = 0

        println("---- ---- ---- -----")
        println("---- order List ----")
        println("---- ---- ---- -----")

        for (Order order : orderList) {
            totalPrice += order.price
        }

        println("---- ---- ---- -----")
        println("TOTAL PRICE : ${totalPrice}")
        println("---- ---- ---- -----")
    }

}
