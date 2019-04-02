package org.toy.til.effetivejava.synchronize;

@FunctionalInterface
public interface SetObserver<E> {

    // 조금 더 직관적인 이름을 주기 위해, 별도의 함수로 분리하였으나, BiConsumer 를 사용해도 문제는 없었다.
    void added(Rule79.ObservableSet<E> set, E element);
}
