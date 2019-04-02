package org.toy.til.effetivejava.synchronize;

import java.util.concurrent.TimeUnit;

public class Rule78 {
    /*
         동기화를 배타적 실행만으로 생각하지만, 다른 관점들도 존재한다.

         자바 언어 명세는 스레드가 필드를 읽을 때 항상 '수정이 완전히 반영된' 값을 얻는다고 보장한다.
         다만, 한 스레드가 저장한 값이 '다른 스레드에게 보이는가?' 는 보장하지 않는다.

         즉, 동기화는 배타적 실행뿐 아니라, 스레드 사이의 안정적인 통신에 꼭 필요하다.

        이유는, 스레드가 만든 변화를 다른 스레드에게 언제 어떻게 보이는지를 규정한 "자바의 메모리 모델" 때문이다.
         */

    public static void main(String[] args) throws InterruptedException {
          case1();
        //case2();
    }

    private static boolean stopRequested = false;
   //private static volatile boolean stopRequested = false;

    public static void case1() throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                ++i;
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true; //
    }

    /*
    위 함수는 끝나지 않고 계속 수행된다.
    이유는 동기화 때문인데, main thread 가 수정한 값을 background thread 가 언제 보게될지 보증할 수 없다.
    또한 동기화코드가 없으면 가상머신지 최적화로, hoisting 을 수행할 수 도 있다. (while (true) { })

    의도대로 수행하기 위해선, synchronized 를 사용해야함.
     */
    public static void case2() throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!isRequested()) {
                ++i;
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested();
    }

    // 개인적 궁금증, 읽기만 동기화 해도 괜찮지 않을까 ?
    public static synchronized void stopRequested() {
        stopRequested = true;
    }

    public static synchronized boolean isRequested() {
        return stopRequested;
    }

    /*
    synchronized 는 배타적 실행 과 thread 간 통신 이라는 개념.
    volatile 을 사용하면 배타적 실행에는 영향이 없지만, 통신 관점에서 항상 최신 값을 가져올 수 있다.
     */

    //private static volatile boolean stopRequested = false;

    /*
    다만 volatile 도 주의해서 사용해야한다.
     */

    private static volatile int count = 0;

    public static int countUp(){
        return count ++;
    }
    /*
    위 코드는 겉보기엔 하나의 연산으로 보이지만, 실제로는 2번 변수에 접근한다.
    1. count 를 읽어올 때
    2. count + 1 을 저장
    즉, 연산 사이를 비집고 들어올 경우 오작동 할 수 있다. safety failure

    요 문제를 해결하기 위해, 위 함수에 synchronized 를 붙이고 volatile 을 삭제하자.
    또한 이런 문제를 해결하기 위해 AtomicLong class 를 사용해보자.
    얘는 synchronize 와 동일한 효과를 보여준다.

    사실 공유자원을 만들지 않는것이 best 이고, 자신이 사용하는 library 나 framework 가 thread safe 한지 인지하고 있어야한다.

     */
}
