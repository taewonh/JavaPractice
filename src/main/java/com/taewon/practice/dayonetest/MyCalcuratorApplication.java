package com.taewon.practice.dayonetest;

public class MyCalcuratorApplication {

    public static void main(String[] args) {

        MyCalcurator myCalcurator = new MyCalcurator();

        myCalcurator.add(10.0);
        myCalcurator.minus(2.0);
        myCalcurator.multiply(2.0);

        myCalcurator.divide(0.0);

        System.out.println(myCalcurator.getResult());
    }
}
