package com.duelgenji.DataStructure;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class GC {
    public static void main(String[] args) {
        Person obj = new Person("a");
        obj = null;
        Person obj1 = new Person("b");
        Person obj2 = new Person("c");
        obj1 = obj2;

        Person obj4 = new Person("e");

        // 当一个对象仅仅被weak reference指向, 而没有任何其他strong reference指向的时候, 如果GC运行, 那么这个对象就会被回收
        //WeakReference的一个特点是它何时被回收是不可确定的, 因为这是由GC运行的不确定性所确定的.
        // 所以, 一般用weak reference引用的对象是有价值被cache, 而且很容易被重新被构建, 且很消耗内存的对象.
        WeakReference<Person> weakReference = new WeakReference<Person>(obj4);




        System.out.println("第1步" + obj);
        System.out.println("第2步" + obj1);
        System.out.println("第3步" + obj2);
        System.out.println("第4步" + new Person("d"));
        System.gc();


    }


}
class Person {
    private String str;

    public Person(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str +"存在";
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        System.out.println(this.str+ "被回收了");
    }
}