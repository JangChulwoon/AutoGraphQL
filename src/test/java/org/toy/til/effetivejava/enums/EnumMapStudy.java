package org.toy.til.effetivejava.enums;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnumMapStudy {

    @Test
    public void wrongPlantTest() {

        List<Plant> plants = Arrays.asList(new Plant("꽃1", Plant.LifeCycle.ANNUAL),
                new Plant("꽃2", Plant.LifeCycle.ANNUAL),
                new Plant("꽃3", Plant.LifeCycle.BIENNEIAL),
                new Plant("꽃4", Plant.LifeCycle.BIENNEIAL),
                new Plant("꽃5", Plant.LifeCycle.PERENNIAL));

        Set<Plant>[] plantsByLifeCycle = new Set[Plant.LifeCycle.values().length];

        // init
        for (int i = 0; i < plantsByLifeCycle.length; ++i) {
            plantsByLifeCycle[i] = new HashSet();
        }

        for (Plant plant : plants) {
            plantsByLifeCycle[plant.lifeCycle.ordinal()].add(plant);
        }

        for (int i = 0; i < plantsByLifeCycle.length; ++i) {
            System.out.printf("%s : %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }


    }

    static class Plant {

        final String name;
        final LifeCycle lifeCycle;

        public Plant(String name, LifeCycle lifeCycle) {
            this.name = name;
            this.lifeCycle = lifeCycle;
        }

        @Override
        public String toString() {
            return name;
        }

        enum LifeCycle {
            ANNUAL, PERENNIAL, BIENNEIAL;
        }
    }
}
