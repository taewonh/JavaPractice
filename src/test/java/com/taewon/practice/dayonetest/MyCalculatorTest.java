package com.taewon.practice.dayonetest;

import com.taewon.practice.dayonetest.calculator.MyCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCalculatorTest {

    @Test
    void addTest() {
        // AAA 패턴
        // Arrange - 준비
        MyCalculator myCalculator = new MyCalculator();

        // Act - 행동
        myCalculator.add(10.0);

        // Assert - 단언/검증
        Assertions.assertEquals(10.0, myCalculator.getResult());
    }

    @Test
    void minusTest() {
        // GWT 패턴
        // Given - 준비
        MyCalculator myCalculator = new MyCalculator(10.0);

        // When - 행동/연산
        myCalculator.minus(5.0);

        // Then - 검증/비교/단언
        Assertions.assertEquals(5.0, myCalculator.getResult());
    }

    @Test
    void multiplyTest() {
        MyCalculator myCalculator = new MyCalculator(2.0);
        myCalculator.multiply(2.0);
        Assertions.assertEquals(4.0, myCalculator.getResult());
    }

    @Test
    void divideTest() {
        MyCalculator myCalculator = new MyCalculator(10.0);
        myCalculator.divide(2.0);
        Assertions.assertEquals(5.0, myCalculator.getResult());
    }

    @Test
    void complicatedCalculateTest() {
        // Given
        MyCalculator myCalculator = new MyCalculator(0.0);

        // When
        Double result = myCalculator.add(10.0)
                .minus(4.0)
                .multiply(2.0)
                .divide(3.0)
                .getResult();

        // Then
        Assertions.assertEquals(4.0, result);
    }

    @Test
    void divideZeroTest() {
        // Given
        MyCalculator myCalculator = new MyCalculator(10.0);

        // When & Then
        Assertions.assertThrows(MyCalculator.ZeroDivisionException.class, () -> myCalculator.divide(0.0));
    }
}