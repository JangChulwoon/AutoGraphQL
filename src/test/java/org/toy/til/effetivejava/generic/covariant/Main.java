package org.toy.til.effetivejava.generic.covariant;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Object[] obj = new Long[5];


 /*       List<String>[] stringList = new ArrayList<>[1]; // 1. compile error
        List<Integer> initList = Arrays.asList(2);
        Object[] objects = stringList;
        objects[0] = initList;
        String s = stringList[0].get(0);
*/

        init(Collections.emptyList());
    }

    public static <T> void init(Collection<T> e) {
        List<T> list = new ArrayList<>(e);
    }
}
