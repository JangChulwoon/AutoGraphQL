package org.toy.til.effetivejava.enums;


import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class EnumMapTest {


    /*
    이런 형태를 위한 코드

    SOLID > LIQUID = MELT
    LIQUID > SOLID = FREEZE
    */
    public enum PhaseUsingOrdinal {
        SOLID, LIQUID, GAS;

        enum Transition {
            MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

            private static final Transition[][] TRANSITIONS = {
                    {null, MELT, SUBLIME},
                    {FREEZE, null, BOIL},
                    {DEPOSIT, CONDENSE, null}
            };

            public static Transition from(PhaseUsingOrdinal from, PhaseUsingOrdinal to) {
                return TRANSITIONS[from.ordinal()][to.ordinal()];
            }
        }
    }

    public enum PhaseUsingEnumMap {
        SOLID, LIQUID, GAS;

        enum Transition {
            MELT(SOLID, LIQUID),
            FREEZE(LIQUID, SOLID),
            BOIL(LIQUID, GAS),
            CONDENSE(GAS, LIQUID),
            SUBLIME(SOLID, GAS),
            DEPOSIT(GAS, SOLID);

            private static final Map<PhaseUsingEnumMap, Map<PhaseUsingEnumMap, Transition>> m =
                    Stream.of(values()).collect(groupingBy(t -> t.)) // ?
            private final PhaseUsingEnumMap from;
            private final PhaseUsingEnumMap to;

            Transition(PhaseUsingEnumMap from, PhaseUsingEnumMap to) {
                this.from = from;
                this.to = to;
            }

            public static Transition from(PhaseUsingEnumMap from, PhaseUsingEnumMap to) {
                return m.get(from).get(to);
            }
        }
    }
}
