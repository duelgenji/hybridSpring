package com.duelgenji.leetcode.easy;

/**
 * https://leetcode-cn.com/problems/SNJvJP/
 * LCP 29. 乐团站位
 */
public class Q0LCP29_orchestra_layout {


    //解法超时，圈大的时候会循环过多次
    public int orchestraLayout(int num, int xPos, int yPos) {

        //切换方向，下标就+1，然后整除4来决定方向
        String[] direction = {"right","down","left","up"};

        //初始边界最大值/最小值，往右往下，初始值是边长，每次换方向逐步-1，往左往上的初始边界为0，随着换方向逐步+1
        long[] border= {num-1,num-1,0,1};
        int direct = 0;
        long count = 0; //计数器，用来做 n%9
        long x = 0, y = 0;

        boolean flag = true;
        while(flag){
//            System.out.println(count);

            switch (direction[direct%4]){
                case "right":
//                    System.out.println("right");
                    if(x!=xPos){
                        count += (border[0]-y);
                    }else{
                        count += (yPos-y);
                        flag = false;
                        continue;
                    }
                    y = border[0]--;
                    direct++;
                    break;
                case "down":
//                    System.out.println("down");
                    if(y!=yPos){
                        count += (border[1]-x);
                    }else{
                        count += (xPos-x);
                        flag = false;
                        continue;

                    }
                    x = border[1]--;
                    direct++;
                    break;
                case "left":
//                    System.out.println("left");
                    if(x!=xPos){
                        count += (y - border[2]);
                    }else{
                        count += (y - yPos);
                        flag = false;
                        continue;

                    }
                    y = border[2]++;
                    direct++;
                    break;
                case "up":
//                    System.out.println("up");
                    if(y!=yPos){
                        count += (x - border[3]);
                    }else{
                        count += (x - xPos);
                        flag = false;
                        continue;

                    }
                    x = border[3]++;
                    direct++;
                    break;
            }
        }

        return (int) ((count%9)+1);

    }

    /**
     * 解题思路
     */
    public int orchestraLayout2(int num, int xPos, int yPos) {

        long level;
        //int 换 long
        long x = xPos;
        long y = yPos;
        long n = num;
        long start;
        if(x <= y){
            //坐标在正方形右上
            level = Math.min(x, n - y - 1);
            start = n * n - (n - 2 * level) * (n - 2 * level) - 1;
            return (int) ((start+(x-level)+(y-level)+1)%9+1);
        }else{
            //坐标在正方形左下
            level = Math.min(y, n - x - 1);
            start = n * n - (n - 2 *(level + 1)) * (n - 2 *(level + 1));
            return (int) ((start-((x-level)+(y-level)))%9+1);

        }


    }

    public static void main(String[] args) {
        Q0LCP29_orchestra_layout leet = new Q0LCP29_orchestra_layout();
        System.out.println(leet.orchestraLayout2(339321193,159626490,332519384));
    }
}
