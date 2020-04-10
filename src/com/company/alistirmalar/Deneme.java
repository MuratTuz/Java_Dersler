package com.company.alistirmalar;

public class Deneme {

    public static void main(String[] args) {

        Vehicle v = new Vehicle();
        Car c = new Car();
        v.drive();
        ((Vehicle)c).drive();
        //v=c;
        //v.drive();
        //Car cc = (Car)new Vehicle();
        //cc.drive();
        //cc.yeni();
    }

   private static class Vehicle {
        public void drive() {
            System.out.println("By vehicle");
        }
    }

    private static class Car extends Vehicle {
        @Override
        public void drive() {
            System.out.println("By car");
        }
        public void yeni(){
            System.out.println("by yeni");
        }
    }



}