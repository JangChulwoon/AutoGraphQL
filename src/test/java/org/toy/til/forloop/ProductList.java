package org.toy.til.forloop;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ProductList implements Iterable {

    private List<String> list;
    private int index = 0;

    public ProductList() {
        this.list = Arrays.asList("hat", "cloth", "shoes");
    }

// Iterator 랑 Iterable 을 보고싶네

    @Override
    public Iterator iterator() {
        return null;
    }

}
