package com.taewon.practice.effective_java.Item12;

import java.util.UnknownFormatConversionException;
import java.util.regex.Pattern;

public class PhoneNumber {

    private Integer areaCode;
    private Integer prefix;
    private Integer lineNum;

    private static final Pattern pattern = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");

    public PhoneNumber(Integer areaCode, Integer prefix, Integer lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return this.areaCode.equals(phoneNumber.areaCode)
                && this.prefix.equals(phoneNumber.prefix)
                && this.lineNum.equals(phoneNumber.lineNum);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(areaCode);
        result = 31 * result + Integer.hashCode(prefix);
        result = 31 * result + Integer.hashCode(lineNum);
        return result;
    }

    @Override
    public String toString() {
        return String.format("전화번호 : %03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    public static PhoneNumber parse(String phoneNumber) {

        if (!PhoneNumber.pattern.matcher(phoneNumber).find()) {
            throw new UnknownFormatConversionException(phoneNumber + " cannot be parsed");
        }

        String[] numbers = phoneNumber.split("-");
        return new PhoneNumber(
                Integer.parseInt(numbers[0]),
                Integer.parseInt(numbers[1]),
                Integer.parseInt(numbers[2]));
    }
}
