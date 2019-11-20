package com.duelgenji.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1191_K_Concatenation_Max_Sum {

    public static int kConcatenationMaxSum(int[] arr, int k) {

        int result = 0;
        int newLength = arr.length * k ;
        int b[] = new int[newLength];

        for (int i = 0; i < k; i++) {
            System.arraycopy(arr, 0 , b, arr.length*i, arr.length);
        }

        return result;
    }


    //一直sum 正数的就继续加，有大于max的就保存，循环两次必然能找到k>2之后的规律。
    //优化 可以只循环一次。
    public static int sum(int a[], int k){

        long current = 0;

        long max = 0;

        long sum = 0;


        for (int i = 0; i < a.length * 2 ; i++) {
            if(i<a.length){
                sum +=a[i];
            }

            if((i == a.length && sum>0) || i>=a.length*2){
                break;
            }

            if(current+a[i%a.length]>0){
                current += a[i%a.length];
                if(current>max){
                    max = current;
                }
            }else{
                current = 0;
            }

            if(i==a.length && k<=1){
                break;
            }
        }

        if(sum>0){
            max = max +  sum * (k-1);
        }

        return (int) (max%1000000007);

    }

    public static void main(String[] args) {

        int a[] = {-7,12,-7,4};

        System.out.println(sum(a,5));



//        copySpeedCompare();
    }


    public static void copySpeedCompare(){
        int a []= {1,2,3,4,5,6,7,8,9};

        long beginTime = System.currentTimeMillis();

        Runtime runtime = Runtime.getRuntime();

        System.out.println("total memory" + runtime.totalMemory()/1024/1024+"mb");
        System.out.println("free memory" + runtime.freeMemory()/1024/1024+"mb");



        int b[] = copy2(a,10000000);

        long endTime = System.currentTimeMillis();

        //run time k = 10000000, copy1 380-400ms, copy2 210-230ms
        System.out.println("run time :" + (endTime-beginTime) + "ms");


    }



    public static int[] copy1(int[] arr, int k){
        int newLength = arr.length * k ;
        int b[] = new int[newLength];

        for (int i = 0; i < newLength; i++) {
            b[i] = arr[i%arr.length];
        }
        return b;

    }

    public static int[] copy2(int[] arr, int k){
        int newLength = arr.length * k ;


        int b[] = new int[newLength];

        for (int i = 0; i < k; i++) {
            System.arraycopy(arr, 0 , b, arr.length*i, arr.length);
        }
        return arr;

    }

}
