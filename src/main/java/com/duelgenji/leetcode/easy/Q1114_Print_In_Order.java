package com.duelgenji.leetcode.easy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Q1114_Print_In_Order {

    Semaphore run2, run3;

    //Semaphore 做法
    //https://leetcode.com/problems/print-in-order/discuss/332890/Java-Basic-semaphore-solution-8ms-36MB

    // volatile boolean 变量做法
    // https://leetcode.com/problems/print-in-order/discuss/333446/Java-solution-beats-100-in-both-time-and-space

    public Q1114_Print_In_Order() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        run2.acquire();
        printSecond.run();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        run3.acquire();
        printThird.run();
    }


    public static void main(String[] args) throws Exception {
        Q1114_Print_In_Order foo = new Q1114_Print_In_Order();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.submit(() -> foo.first(() -> System.out.println("one")));
//        executorService.submit(() -> foo.third(() -> System.out.println("third")));
//        executorService.submit(() -> foo.second(() -> System.out.println("second")));
    }
}
