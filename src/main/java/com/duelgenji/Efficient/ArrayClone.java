package com.duelgenji.Efficient;

import java.util.Arrays;


//数组克隆比较
//https://blog.csdn.net/lys1695227550/article/details/82432779
public class ArrayClone {

    public static void testClone() {
        int n=10000;
        int[] a= new int[n];
        for(int i=0;i<n;i++) {
            a[i]=i;
        }
        long beginTime = System.nanoTime();
        int[] b=a.clone();
        long endTime = System.nanoTime();
        System.out.println("a.clone()运行了"+(endTime-beginTime)+"ns");
        System.out.println(b[n-1]);
    }

    public static void testSystemArrayCopy() {
        int n=10000;
        int[] a= new int[n];
        for(int i=0;i<n;i++) {
            a[i]=i;
        }
        int[] b= new int[n];
        long beginTime = System.nanoTime();
//		参数含义：（原数组， 原数组的开始位置， 目标数组， 目标数组的开始位置， 拷贝个数）
        System.arraycopy(a, 0, b, 0, n);
        long endTime = System.nanoTime();
        System.out.println("System.arraycopy()运行了"+(endTime-beginTime)+"ns");
        System.out.println(b[n-1]);
    }
    //Arrays.copyOf底层其实也是用的System.arraycopy
    public static void testArraysCopyof() {
        int n=10000;
        int[] a= new int[n];
        for(int i=0;i<n;i++) {
            a[i]=i;
        }
        long beginTime = System.nanoTime();
//		参数含义：（原数组，拷贝的个数）
        int[] b=Arrays.copyOf(a, n);
        long endTime = System.nanoTime();
        System.out.println("Arrays.copyOf()运行了"+(endTime-beginTime)+"ns");
        System.out.println(b[n-1]);
    }
    //Arrays.copyOfRange底层其实也是用的System.arraycopy，只不过封装了一个方法
    public static void testCopyOfRange() {
        int n=10000;
        int[] a= new int[n];
        for(int i=0;i<n;i++) {
            a[i]=i;
        }
        long beginTime = System.nanoTime();
//		参数含义：（原数组，开始位置，拷贝的个数）
        int[] b= Arrays.copyOfRange(a, 0, n);
        long endTime = System.nanoTime();
        System.out.println("Arrays.copyOfRange()运行了"+(endTime-beginTime)+"ns");
        System.out.println(b[n-1]);
    }


    public static void testFor() {
        int n=10000;
        int[] a= new int[n];
        for(int i=0;i<n;i++) {
            a[i]=i;
        }
        int[] b= new int[n];
        long beginTime = System.nanoTime();
        for(int i=0;i<a.length;i++) {
            b[i]=a[i];
        }
        long endTime = System.nanoTime();
        System.out.println("for循环运行了"+(endTime-beginTime)+"ns");
        System.out.println(b[n-1]);

    }

    public static void main(String[] args) {
        testClone();
        testSystemArrayCopy();
        testArraysCopyof();
        testCopyOfRange();
        testFor();
    }
}