package org.toy.til.effetivejava.synchronize;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Rule79 {


    public static void main(String[] args) {

//        normalCase();

        badCase();
        //badCase2();
        /*
        외계인 메서드 호출을 하면 안됨
        -> 재정의 가능하거나, functional Interface
         */
    }

    // call back 함수가 수정하는것 까진 막지 못한다 ?
    private static void badCase() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    // lambda 는 자기 자신을 참조할 수 없다. item 42
                    // lambda 는 this 를 바깥 애를 가르킨다.
                    set.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; ++i) {
            set.add(i);
        }
    }

    // error 는 안나지만 교착상태에 빠짐
    private static void badCase2() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    ExecutorService es = Executors.newSingleThreadExecutor();

                    try {
                        es.submit(()-> set.removeObserver(this)).get();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    } catch (ExecutionException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        for (int i = 0; i < 100; ++i) {
            set.add(i);
        }
    }

    private static void normalCase() {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet());

        set.addObserver((s, e) -> System.out.println(e));

        for (int i = 0; i < 100; ++i) {
            set.add(i);
        }
    }
    /*
    과도한 동기화는 피해야하며, 동기화 block 안에서는 제어를 절대 client 에게 넘겨서는 안된다.

    0. 재정의 할 수 있는 메서드를 실행해선 안되고
    1. 클라이언트가 넘겨준 함수 객체를 실행해서도 안된다.
     */

    // added 시, Observable 함수를 호출한다.
    static class ObservableSet<E> extends ForwadingSet<E> {

        public ObservableSet(Set s) {
            super(s);
        }

        // CopyOnWriteArrayList 내부를 변경하는 작업은 복사본을 만들어서 수행해준다.
        private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();


        public void addObserver(SetObserver<E> observer) {
            synchronized (observers) {
                observers.add(observer);
            }
        }

        public boolean removeObserver(SetObserver<E> observer) {

            synchronized (observers) {
                return observers.remove(observer);
            }
        }

        public void notifyElementAdded(E element) {
            synchronized (observers) {
                for (SetObserver<E> observer : observers) {
                    observer.added(this, element);
                }
            }
        }

        // 복사본 사용. 다만 교착상태는 피할수 없는듯함
        // 혹은 CopyOnWriteArrayList 를 사용
        public void notifyElementAddedForSolution(E element) {
            List<SetObserver<E>> snapshot = null;
            synchronized (observers) {
                snapshot = new ArrayList<>(observers);
            }
            for (SetObserver<E> observer : snapshot) {
                observer.added(this, element);
            }
        }

        @Override
        public boolean add(E o) {
            boolean added = super.add(o);
            if (added) {
                notifyElementAdded(o);
                //notifyElementAddedForSolution(o);
            }
            return added;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            boolean result = false;
            for (E element : c) {
                result |= add(element);
            }
            return result;
        }
    }


    /*
    1. 위 같은 동기화 이슈들을 해결하기 위해, 외계인 메서드 호출을 동기화 블록 바깥으로 호출하면 된다.
    (동기화 블록 내부에서 깊은 복사를 사용하고, 실제 호출은 외부에서 동기화 블록 바깥에서 호출하게끔!)
        - 열린 호출

    2. 혹은 CopyOnWriteArrayList 라는 collection 을 사용하자
    (수정이 드믈고, 읽기만 일어나면 최적.)

    0. 동기화 블럭에선 가능한 일을 적게해야한다.

    동기화에 대한 2가지 방법

    1. 동기화를 하지않는다 - 외부에서 알아서 하도록
    - 다만 client 가 여러 스레드로 구동되는 상황이라면, 외부에서 제어하기가 어려울수도 있다.

    2. 동기화를 내부에서 수행해, thread safe 하게 만든다.
    이 경우, 외부에서 객체 전체를 락을 거는것보다 성능이 월등이 좋을 경우에만 사용한다 !  -> concurrent lib 가 여기에 해당
     */

}
