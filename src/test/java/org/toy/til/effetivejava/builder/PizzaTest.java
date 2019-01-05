package org.toy.til.effetivejava.builder;

import org.junit.Test;

public class PizzaTest {

    // builder pattern Example.
    @Test
    public void builderPattern() {
        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .sauceInside().build();


    }
}
