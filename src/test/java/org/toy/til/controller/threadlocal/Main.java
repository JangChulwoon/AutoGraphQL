package org.toy.til.controller.threadlocal;

public class Main {


    public static void main(String[] args) throws Exception {
        SharedRersource r1 = new SharedRersource();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main thread Exiting...");
    }

}

class SharedRersource implements Runnable {


    private ThreadLocal<Integer> threadId = new ThreadLocal() {
        protected Integer initialValue() {
            return (int) (Math.random() * 100);
        }
    };

    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadId.get());

    }
};

