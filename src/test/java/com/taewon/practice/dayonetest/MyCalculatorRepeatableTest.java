package com.taewon.practice.dayonetest;

import com.taewon.practice.dayonetest.calculator.MyCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MyCalculatorRepeatableTest {

    @DisplayName("덧셈 반복 테스트 - 단순")
    @RepeatedTest(5)
    public void repeatedAddTest() {
        // AAA 패턴
        // Arrange - 준비
        MyCalculator myCalculator = new MyCalculator();

        // Act - 행동
        myCalculator.add(10.0);

        // Assert - 단언/검증
        Assertions.assertEquals(10.0, myCalculator.getResult());
    }

    @DisplayName("덧셈 반복 테스트 - 파라미터 입력")
    @ParameterizedTest
    @MethodSource("addTestParameters")
    public void addParameterizedTest(Double addValue, Double expect) {
        // AAA 패턴
        // Arrange - 준비
        MyCalculator myCalculator = new MyCalculator(0.0);

        // Act - 행동
        myCalculator.add(addValue);

        // Assert - 단언/검증
        Assertions.assertEquals(expect, myCalculator.getResult());
    }

    public static Stream<Arguments> addTestParameters() {
        return Stream.of(
                Arguments.of(10.0, 10.0),
                Arguments.of(20.0, 20.0),
                Arguments.of(30.0, 30.0),
                Arguments.of(40.0, 40.0),
                Arguments.of(50.0, 50.0)
        );
    }

    @DisplayName("사칙 연산 반복 테스트 - 파라미터 입력")
    @ParameterizedTest
    @MethodSource("complicatedTestParameters")
    public void complicatedCalculatorParameterizedTest(Double addValue,
                                                       Double minusValue,
                                                       Double multiplyValue,
                                                       Double divideValue,
                                                       Double expect) {
        // Given
        MyCalculator myCalculator = new MyCalculator(0.0);

        // When
        Double result = myCalculator.add(addValue)
                .minus(minusValue)
                .multiply(multiplyValue)
                .divide(divideValue)
                .getResult();

        // Then
        Assertions.assertEquals(expect, result);
    }

    public static Stream<Arguments> complicatedTestParameters() {
        return Stream.of(
                Arguments.of(10.0, 4.0, 2.0, 3.0, 4.0),
                Arguments.of(4.0, 2.0, 4.0, 4.0, 2.0)
        );
    }
}
