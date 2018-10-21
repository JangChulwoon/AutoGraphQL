package org.toy.til.refactoring.ch06

class POSMachine {

    void printOwing(orderList) {

        printBanner()

        def totalPrice = getTotalPrice(orderList)

        printTotalPrice(totalPrice)
    }

    // 지역변수가 단순히 읽히기만 한다면, 넘기면 된다. (java 의 경우 final 명시해주면 좋을 듯 )
    private void printTotalPrice(totalPrice) {
        println "---- ---- ---- -----"
        println "TOTAL PRICE : ${totalPrice}"
        println "---- ---- ---- -----"
    }

    // 지역변수가 외부에서도 쓰일 경우, return 하는 형식으로 사용. totalPrice를 매개변수로 받는건 좋지 못함.
    private int getTotalPrice(orderList) {
        def totalPrice = 0
        for (Order order : orderList) {
            totalPrice += order.price
        }
        totalPrice
    }

    private void printBanner() {
        println "---- ---- ---- -----"
        println "---- order List ----"
        println "---- ---- ---- -----"
    }

}
