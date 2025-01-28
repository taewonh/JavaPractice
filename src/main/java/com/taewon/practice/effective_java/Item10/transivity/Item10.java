package com.taewon.practice.effective_java.Item10.transivity;

import java.awt.*;

public class Item10 {

    /*
     * equals 메소드 재정의시 추이성 규약 위반을 보여주는 예제
     * */
    public static void main(String[] args) {
        Item10 item10 = new Item10();
        item10.testTransivityViolation();
        item10.testInfiniteRecursion();
    }

    private void testTransivityViolation() {
        ColorPoint a = new ColorPoint(1, 2, Color.RED);
        com.taewon.practice.effective_java.Item10.transivity.Point b = new com.taewon.practice.effective_java.Item10.transivity.Point(1, 2);
        ColorPoint c = new ColorPoint(1, 2, Color.BLUE);

        System.out.println(a.equals(b)); //true
        System.out.println(b.equals(c)); //true
        System.out.println(a.equals(c)); //false
    }

    /*
    * 추이성 위반 시 발생할 수 있는 무한재귀
    * */
    private void testInfiniteRecursion() {
        com.taewon.practice.effective_java.Item10.transivity.Point cp = new ColorPoint(1, 2, Color.RED);
        Point sp = new SmellPoint(1, 2, Smell.SWEET);
        System.out.println(cp.equals(sp));  //?
    }
}
