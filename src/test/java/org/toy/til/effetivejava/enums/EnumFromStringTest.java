package org.toy.til.effetivejava.enums;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EnumFromStringTest {


    @Test
    public void valueOf() {
        // 기본 valueOf를 제공한다.
        Fruit apple = Fruit.valueOf("APPLE");

        Assert.assertTrue(apple == Fruit.APPLE);
    }

    @Test
    public void fromString() {
        Fruit apple = Fruit.fromString("num : 1");

        Assert.assertTrue(apple == Fruit.APPLE);

    }

    enum Fruit {
        APPLE(1),
        ORANGE(2);

        static Map<String, Fruit> fruitMap;
        int num;

        Fruit(int num) {
            this.num = num;
        }

        public static Fruit fromString(String toString) {
            if (fruitMap == null) {
                fruitMap = initFruitMap();
            }

            return fruitMap.get(toString);

        }

        private static Map initFruitMap() {
            Map map = new HashMap();
            for (Fruit fruit : values()) {
                map.put(fruit.toString(), fruit);
            }
            return map;
        }

        @Override
        public String toString() {
            return String.format("num : %d", this.num);
        }
    }
}
