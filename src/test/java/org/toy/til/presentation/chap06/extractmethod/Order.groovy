package org.toy.til.presentation.chap06.extractmethod

class Order {

    def price;

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
