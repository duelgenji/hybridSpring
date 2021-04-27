package com.duelgenji.Java.playground;

public class EasyCon {

    private static int facing = 0;

    public void turnRight(){
        facing += 90;
    }

    public void turnLeft(){
        facing -= 90;
    }

    public void turnAround(){
        facing += 180;
    }

    public String showDirection(){

        int result = facing % 360;
        switch (result){
            case 90:
                return "RIGHT";
            case -270:
                return "RIGHT";
            case 180:
                return "BACK";
            case -180:
                return "BACK";
            case 270:
                return "LEFT";
            case -90:
                return "LEFT";
            case 0:
                return "FRONT";
            default:
                facing = 0;
                return "FRONT";
        }
    }

    public static void main(String[] args) {
        EasyCon ec = new EasyCon();
        System.out.println(ec.showDirection());
        ec.turnLeft();
        System.out.println(ec.showDirection());
        ec.turnRight();
        System.out.println(ec.showDirection());
        ec.turnAround();
        System.out.println(ec.showDirection());
        ec.turnLeft();
        System.out.println(ec.showDirection());

    }

}
