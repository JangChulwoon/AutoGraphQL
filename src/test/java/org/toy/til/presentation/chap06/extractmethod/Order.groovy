package org.toy.til.presentation.chap06.extractmethod

class Order {

    def price;

    void printOwing(List<Order> orderList) {
        getPrint()
        def totalPrice1 = 0
        for (Order order : (orderList)) {
            totalPrice1 += order.price
        }
        def totalPrice = totalPrice1
        getPrintPrice(totalPrice)
    }

    private getPrintPrice(totalPrice) {
        println("---- ---- ---- -----")
        println("TOTAL PRICE : ${totalPrice}")
        println("---- ---- ---- -----")
    }


    private getPrint() {
        println("---- ---- ---- -----")
        println("---- order List ----")
        println("---- ---- ---- -----")
    }

}
