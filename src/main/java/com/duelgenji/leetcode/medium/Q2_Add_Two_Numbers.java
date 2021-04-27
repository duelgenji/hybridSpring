package com.duelgenji.leetcode.medium;

public class Q2_Add_Two_Numbers {


    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int firstNumber = 0;
        int secondNumber = 0;
        while(l1!=null){
            firstNumber = firstNumber * 10 + l1.val;

            l1 = l1.next;
        }

        while(l2!=null){
            secondNumber = secondNumber * 10 + l2.val;
            l2 = l2.next;
        }

        int result = firstNumber + secondNumber;
        ListNode resultNode = new ListNode(0);
        ListNode subNode = resultNode;

        while(result>=0){

            ListNode sumNode = new ListNode(result % 10);
            subNode.next = sumNode;
            subNode = sumNode;

            result/=10;


        }



        return resultNode.next;

    }


}
