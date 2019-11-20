package com.duelgenji.leetcode.easy;

import java.util.concurrent.Semaphore;

public class Q1115_Print_FooBar_Alternately {
    private int n;

    Semaphore foo,bar;


    public Q1115_Print_FooBar_Alternately(int n) throws InterruptedException {
        this.n = n;
        foo =  new Semaphore(1);
        bar =  new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            foo.acquire();
            System.out.println("foo");
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            System.out.println("bar");
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }

    public static void main(String[] args) {
        try {
            Q1115_Print_FooBar_Alternately a = new Q1115_Print_FooBar_Alternately(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
