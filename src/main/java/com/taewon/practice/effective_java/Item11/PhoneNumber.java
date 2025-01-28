package com.taewon.practice.effective_java.Item11;

public class PhoneNumber {

    protected int firstNumber;
    protected int secondNumber;
    protected int thirdNumber;

    public PhoneNumber(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PhoneNumber)) {
            return false;
        }

        PhoneNumber p = (PhoneNumber) o;
        return this.firstNumber == p.firstNumber &&
                this.secondNumber == p.secondNumber &&
                this.thirdNumber == p.thirdNumber;
    }
}
