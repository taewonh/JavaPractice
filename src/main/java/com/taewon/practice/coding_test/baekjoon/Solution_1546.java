package com.taewon.practice.coding_test.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1546 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int maxNumber = 0;
        List<Integer> inputNumbers = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            int inputNumber = scanner.nextInt();
            inputNumbers.add(inputNumber);
            if (inputNumber > maxNumber) {
                maxNumber = inputNumber;
            }
        }

        double sum = 0.0;
        for (int index = 0; index < count; index++) {
            int currentNumber = inputNumbers.get(index);
            double adjustNumber = (double) currentNumber / maxNumber * 100;
            sum += adjustNumber;
        }

        System.out.println(sum / count);
    }
}
