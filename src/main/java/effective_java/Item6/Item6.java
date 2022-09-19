package main.java.effective_java.Item6;

import java.util.regex.Pattern;

/*
* 객체 생성과 파괴
* Item6. 불필요한 객체 생성을 피하라.
* */
public class Item6 {

    private final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static void main(String[] args) {
        Item6 item6 = new Item6();
//        item6.stringTest();
        item6.patternMatchTest();
    }

    public void patternMatchTest() {
        String str = "아무 글자";
        // 성능에 영향을 주는 메소드 3번 호출
        boolean romanNumeral = isRomanNumeral(str);
        romanNumeral = isRomanNumeral(str);
        romanNumeral = isRomanNumeral(str);

        // 성능에 영향을 별로(?) 주지 않는 메소드 3번 호출
        boolean romanNumeralReuse = isRomanNumeralReuse(str);
        romanNumeralReuse = isRomanNumeralReuse(str);
        romanNumeralReuse = isRomanNumeralReuse(str);
    }

    /*
    * 재 사용시 성능에 영향을 줄 수 있는 정규표현식 matche 기능
    * 내부적으로 Patter 인스턴스가 계속해서 새로 만들어져 GC 대상이 된다.
    * (Pattern은 인스턴스 생성 비용이 높다.)
    * */
    private boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /*
    * 생성 비용이 높은 Pattern을 한번 만들어주고 계속해서 재사용 한다.
    * */
    private boolean isRomanNumeralReuse(String s) {
        return ROMAN.matcher(s).matches();
    }

    public void stringTest() {

        /*
        * 리터럴 방식으로 생성한 String 객체는 동일한 값을 입력하면 동일한 레퍼런스를 사용한다.
        * 이는 Heap 영역 내부의 String Constant Pool 에 저장된 값을 재사용하기 때문이다.
        * */
        String str1 = "str";
        String str2 = "str";
        System.out.println(str1 == str2);

        /*
        * New 키워드로 String 객체를 생성하면 내부의 String 값이 같더라도
        * 그때마다 메모리 영역을 할당받는다. 따라서 아래 두 값은 다른 인스턴스이다.
        * */
        String str3 = new String("str3");
        String str4 = new String("str4");
        System.out.println(str3 == str4);
    }
}
