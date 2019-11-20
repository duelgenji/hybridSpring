package com.duelgenji.leetcode.easy;

public class Q1108_IP_ADDRESS {

    public String defangIPaddr(String address) {

        StringBuilder res = new StringBuilder();
        for (String s : address.split("")) {
            if(s.equals(".")){
                res.append("[").append(s).append("]");
            }else{
                res.append(s);
            }
        }

        return  res.toString();
    }

    public static void main(String[] args) {

        String a = "1.1.1.1";
        System.out.println(a.replace(".","[.]"));
    }
}
