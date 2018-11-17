package org.toy.til.refactoring.ch08.selfencapsulatefield;

public class Product {

    private static final double LIMIT_RATE = 0.5;
    private int price;
    private int count;
    private double discount;

    public Product() {
    }

    public Product(int price, int count, int discount) {
        this.price = price;
        this.count = count;
        this.discount = discount;
    }

    public double getAmountPrice() {
        return (getPrice() * getCount()) - (getPrice() * getDiscount());
    }

    public double getDiscount() {
        if (discount > LIMIT_RATE) {
            return LIMIT_RATE;
        }
        return discount;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
