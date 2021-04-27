package com.duelgenji.leetcode.easy;


//https://leetcode-cn.com/problems/can-place-flowers/submissions/

public class Q0605_can_place_flowers {


    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        //总共能种的数量
        int result = 0;

        //连续0的数量
        int current_zero_count = 0;

        //如果左边界为0，那初始值可以+1，因为同样的连续2个0：【0，0，1】 是可以种1，但是【1，0，0，1】无法种
        current_zero_count += flowerbed[0]==0?1:0;

        for (int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i] == 0){
                current_zero_count++;
            }else if(flowerbed[i] == 1){

                //连续0的数量大于3才有意义，由于要间隔种，所以要 （n-1）/2
                if(current_zero_count>=3){
                    result += (current_zero_count-1)/2;
                }
                current_zero_count = 0;
            }
        }

        //同左边界逻辑，右边界为0的话也可以+1，只不过这边计算都是n-1/2，所以直接用n/2 就是+1的效果了。
        if(flowerbed[flowerbed.length-1]==0){
            result += current_zero_count/2;

        }


        return result >= n;
    }

    public static void main(String[] args) {
        Q0605_can_place_flowers leet = new Q0605_can_place_flowers();

        int[] a = {0,0,0,0,0};
        System.out.println(leet.canPlaceFlowers(a,2));
    }
}
