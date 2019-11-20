package com.duelgenji.DataStructure;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Map {


    /**
     * 接口 interface
     * SortedMap -> Map 根据key排序
     * NavigableMap -> SortedMap 可以sub map
     */


    /** 类
    HashMap 数组 + 链表 java1.7 ;1.8超过8个 变为红黑树 非线程安全 无序 可以有null
    内部类 KeySet EntrySet 都是继承 AbstractSet
    Collections.synchronizedMap()
    concurrentHashMap 推荐
    Hashtable 数据结构同HashMap 线程安全 synchronized 不可以有null 官方不推荐。淘汰

    TreeMap 有排序 红黑树  key String字典排序 数字大小排序， 也可以自定义排序 implements SortedMap
     TreeMap<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
                 @Override
                public int compare(String o1, String o2) {
                        ..
                }});
    LinkedHashMap 插入先后顺序 (每个entry 有 before 和 after）

     WeakHashMap key 弱引用 key被垃圾回收后再次访问WeakHashMap value也会被回收


     IdentityHashMap 关键点在于key判断 用==来比较 ，也就是说是引用相等就等于key重复

     EnumMap 存放枚举的map
     相关优势文章
     https://yq.aliyun.com/articles/238440?spm=5176.10695662.1996646101.searchclickresult.26b2d60bhBVjcS

     */


    public void test(){


        Hashtable map = new Hashtable();
        map.put(null,null);
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
//        EnumMap enumMap = new EnumMap();
        hashMap.entrySet();
//        Collections;
//        Arrays.sort();

    }

    public static void main(String[] args) {
//        new Map().test();

        for(int i = 0;i<200;i++){
            System.out.print((char)i);
        }


    }

//    public static void main(String[] args){
//        String str = "aaaaaaaccccccccccccccccccccccaaaabb";
////   用map实现
////   TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();
////   for(Character ch : str.toCharArray()){
////     if((ch>='a' && ch<'z')||(ch>'A' && ch<'Z')){
////       Integer count = map.get(ch);
////       map.put(ch, null==count?1:count+1);
////     }
////   }
////
////   System.out.println(Collections.max(map.values()));
//        //用普通数组实现
//        int[] aa = new int[60];
//        for(char temp:str.toCharArray()){
//            if((temp>=65 && temp<=90)||(temp>=97 && temp<=122)){
//                temp -= 65;
//                aa[temp]++;
//            }
//        }
//        int max = aa[0]; int position = 0;
//        for(int i=0;i<aa.length;i++){
//            if(aa[i]>max){
//                max = aa[i]; position = i;
//            }
//        }
//        System.out.println(max);
//        System.out.println("字母"+(char)(position+65) + "出现" + max + "次");
//    }

}
