package effective_java.Item1;

import java.util.EnumSet;

/*
* 객체 생성과 파괴
* Item1. 생성자 대신 정적 팩터리 메소드를 고려하라.
* */
public class Item1 {


    public static void main(String[] args) {
        Item1 item1 = new Item1();
        item1.advantage4();
    }

    /*
    * 장점4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
    * */
    public void advantage4() {
        EnumSet noneEnumSet = EnumSet.noneOf(DayOfWeek.class);
        EnumSet allEnumSet = EnumSet.allOf(DayOfWeek.class);
        System.out.println("noneEnumSet: " + noneEnumSet);
        System.out.println("allEnumSet: " + allEnumSet);
    }
}
