package main.java.effective_java.Item10.symmetry;


import java.awt.*;

public class Item10 {

    /*
    * equals 메소드 재정의시 대칭성 규약 위반을 보여주는 예제
    * */
    public static void main(String[] args) {
        Item10 item10 = new Item10();
        item10.testSymmetryViolation();
    }

    private void testSymmetryViolation() {
        ColorPoint a = new ColorPoint(1, 2, Color.RED);
        Point b = new Point(1,2);
        System.out.println(a.equals(b)); //false
        System.out.println(b.equals(a)); //true
    }
}
