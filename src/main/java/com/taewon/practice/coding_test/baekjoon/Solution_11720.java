package com.taewon.practice.coding_test.baekjoon;

import java.util.Scanner;

public class Solution_11720 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String number = scanner.next();

        char[] charArray = number.toCharArray();

        int sum = 0;
        for (int index = 0; index < number.length(); index++) {
            String substring = number.substring(index, index + 1);
            sum += Integer.parseInt(substring);
        }
        System.out.println(sum);
    }
}
