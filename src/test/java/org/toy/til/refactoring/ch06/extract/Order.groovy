package org.toy.til.refactoring.ch06.extract

class Order {
    String name
    int price

    Order(String name, int price) {
        this.name = name
        this.price = price
    }
}
