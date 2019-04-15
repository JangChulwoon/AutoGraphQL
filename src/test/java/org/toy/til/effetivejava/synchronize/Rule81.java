package org.toy.til.effetivejava.synchronize;

import java.util.concurrent.*;

public class Rule81 {
    /**
     * notify / wait 보단 동시성 유틸리티를 사용하라
     *
     * java.util.concurrent 의 고수준 유틸리티는 세 범주로 나눌 수 있는데,
     * 1. 실행자 프레임 워크
     * 2. 동시성 컬렉션
     * 3. 동기화 장치 (synchronized)
     *
     * warning 동시성 컬렉션을 사용할 경우, 외부에서 Lock 을 거는 행위는 하지말자 (오히려 성능이 더 안좋아진다.)
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue(10);

        Executor executor = Executors.newFixedThreadPool(10);


        executor.execute(()->{
            try {
                System.out.println(queue.poll(5, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        executor.execute(()->{
            try {
                queue.put("string");
                queue.put("q");
                System.out.println("input string");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // DDD ?
        // 1차는 5월까지
    }
}
