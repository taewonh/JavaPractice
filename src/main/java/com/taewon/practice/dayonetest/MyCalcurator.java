package com.taewon.practice.dayonetest;

public class MyCalcurator {

    private Double result;

    public MyCalcurator() {
        this.result = 0.0;
    }

    public MyCalcurator(Double initResult) {
        this.result = initResult;
    }

    public MyCalcurator add(Double number) {
        this.result += number;
        return this;
    }

    public MyCalcurator minus(Double number) {
        this.result -= number;
        return this;
    }

    public MyCalcurator multiply(Double number) {
        this.result *= number;
        return this;
    }

    public MyCalcurator divide(Double number) {
        if (number == 0.0) {
            throw new ZeroDivisionException();
        }

        this.result /= number;
        return this;
    }

    public Double getResult() {
        return this.result;
    }

    public static class ZeroDivisionException extends RuntimeException {

    }
}
