package main.java.effective_java.Item10.liskov;

import java.awt.*;

public class Item10 {

    /*
     * equals 메소드 재정의시 리스코프 치환원칙 위반을 보여주는 예제
     * */
    public static void main(String[] args) {
        Item10 item10 = new Item10();
        item10.testLiskovPrinciple();
    }

    private void testLiskovPrinciple() {
        Point point = new Point(1, 0);
        ColorPoint colorPoint = new ColorPoint(1, 0, Color.RED);
        System.out.println(Point.onUnitCircle(point)); //true
        System.out.println(Point.onUnitCircle(colorPoint)); //false
    }
}
