package com.duelgenji.hybridSpring;

import java.util.*;

public class Test {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static String isPossible(int a, int b, int c, int d) {
        // Write your code here

        if(a==c && b==d){
            return "Yes";
        }
        if(a>c || b>d){
            return "No";
        }

        return isPossible(a+b,b,c,d).equals("Yes")?isPossible(a+b,b,c,d):isPossible(a,a+b,c,d);

    }

    public static String getFavoriteCities(List<String> userCities) {
        java.util.Map<String, Integer> countMap = new java.util.HashMap<>();

        int current, max = 0;

        for (String userCity : userCities) {
            for(String cityName : userCity.split("->")){
                current = countMap.getOrDefault(cityName, 0) + 1;
                countMap.put(cityName, current);
                if(current > max){
                    max = current;
                }

            }
        }

        List<String> resultCities = new ArrayList<>();
        for(String key : countMap.keySet()){
            if(countMap.get(key)==max){
                resultCities.add(key);
            }

        }

//        Collections.sort(resultCities);
        StringBuilder sb = new StringBuilder();
        for(String city : resultCities){

            sb.append(city).append(", ");
        }
        sb.append(max);
        System.out.println(sb);

        return sb.toString();

    }
    public static String CalculateBinaryNumbers(List<String> array) {

        String result = "0";
        for(int i=0 ;i<array.size();i+=2){
            result = plus(result,array.get(i));
        }
        for(int i=1 ;i<array.size();i+=2){
            StringBuilder sb= new StringBuilder(array.get(i));
            sb.reverse();
            result = plus(result,sb.toString());
        }

        return result;
    }

    private static String plus(String a, String b){
        int lenA = a.length();
        int lenB = b.length();
        int len = Math.max(lenA, lenB);
        int i = 0, q = 0;
        StringBuilder sb= new StringBuilder();
        while(i<len){
            if(i<lenA){
                q+= a.charAt(lenA-1-i)-'0';
            }
            if(i<lenB){
                q+= b.charAt(lenB-1-i)-'0';
            }
            sb.insert(0,q%2);
            q/=2;
            i++;
        }
        if(q>0){
            sb.insert(0,q);
        }
        return sb.toString();
    }

    public static void main(String[] args) {


//        List<String> stringList = new ArrayList<>();
//        stringList.add("4");
//        stringList.add("Shanghai->Beijing->Tianjin->Changchun");
//        stringList.add("JiangSu->Beijing->NingBo->Changchun");
//        stringList.add("Shanghai->ChongQing->HaErBin->HeiLongJiang");
//        stringList.add("Shanghai->Beijing->NanJin->HangZhou");
//        getFavoriteCities(stringList);

//        List<String> stringList = new ArrayList<>();
//        stringList.add("1100");
//        stringList.add("0011");
//        System.out.println(CalculateBinaryNumbers(stringList));



    }
}
