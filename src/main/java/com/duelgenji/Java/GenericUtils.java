package com.duelgenji.Java;

import javax.persistence.GeneratedValue;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

public class GenericUtils<T> {


    public void test(T t){


        for (Field declaredField : t.getClass().getDeclaredFields()) {

            System.out.println(declaredField.getName());
            try {
                declaredField.setAccessible(true);
                System.out.println(declaredField.get(t));
                if(declaredField.getType()==Date.class){
                    System.out.println(declaredField.getType().getSimpleName());
                }


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }


    public void list(List<T> list){

        Class cls = list.get(0).getClass();
        System.out.println(list.get(0).getClass().getSimpleName());

        for (Field declaredField : cls.getDeclaredFields()) {
            declaredField.setAccessible(true);
            System.out.println(declaredField.getAnnotation(GeneratedValue.class));
            System.out.println(declaredField.getName());
            try {
                System.out.println(declaredField.get(list.get(0)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }



    }


    public static void main(String[] args) {
//        GenericUtils testUtils = new GenericUtils();
//        testUtils.test(new KpeMfSku());
//        testUtils.list(Arrays.asList(new KpeMfSku()));

    }


}
