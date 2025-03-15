package com.taewon.practice.coding_test.baekjoon;

import java.util.Scanner;

public class Solution_2018 {

    public static void main(String[] args) {

        int count = 0;

        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();

        for (int point_1 = 1; point_1 <= inputNumber; point_1++) {

            int sumNumber = point_1;

            for (int point_2 = point_1; point_2 <= inputNumber; point_2++) {
                if (point_1 != point_2) {
                    sumNumber = sumNumber + point_2;
                }
                if (sumNumber < inputNumber) {
                    continue;
                }
                if (sumNumber == inputNumber) {
                    count++;
                }
                break;
            }
        }

        System.out.println(count);
    }
}
