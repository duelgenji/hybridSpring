package com.duelgenji.leetcode.medium;

import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 *
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/even-odd-tree
 */
public class Q01609 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right; }
    }

    public boolean isEvenOddTree(TreeNode root) {

        return isEvenOdd(0, Collections.singletonList(root));

    }

    public boolean isEvenOdd(int level, List<TreeNode> nodes){


        List<TreeNode> next = new ArrayList<>();

        for (int i = 0; i < nodes.size(); i++) {

            TreeNode node =  nodes.get(i);
            if(level%2==0){
                //偶数 level
                if(node.val%2 == 0){
                    return false;
                }
                if(i>0 && node.val <= nodes.get(i-1).val){
                    return false;
                }

            }else{
                //奇数level
                if(node.val%2 == 1){
                    return false;
                }
                if(i>0 && node.val >= nodes.get(i-1).val){
                    return false;
                }
            }



            if(node.left!=null){
                next.add(node.left);
            }
            if(node.right!=null){
                next.add(node.right);
            }
        }

        if(next.size()==0){
            return true;
        }

        return isEvenOdd(level+1,next);
    }


    public static void main(String[] args) {
        Q01609 question = new Q01609();

        TreeNode node = new TreeNode();
        node.val = 1;

        TreeNode node1 = new TreeNode();
        node1.val = 10;

        TreeNode node2 = new TreeNode();
        node2.val = 4;

        node.left=node1;
        node.right=node2;


        System.out.println(question.isEvenOddTree(node));


    }
}
