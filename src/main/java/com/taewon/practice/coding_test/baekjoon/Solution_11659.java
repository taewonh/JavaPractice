package com.taewon.practice.coding_test.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_11659 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int inputCount = scanner.nextInt();

        int answerCount = scanner.nextInt();
        List<Integer> answers = new ArrayList<>();

        List<Integer> inputNumbers = new ArrayList<>();
        for (int count = 0; count < inputCount; count++) {
            int inputNumber = scanner.nextInt();
            inputNumbers.add(inputNumber);
        }

        List<Integer> sumNumbers = new ArrayList<>();
        for (int count = 0; count < inputCount; count++) {

            int inputNumber = inputNumbers.get(count);
            if (count == 0) {
                sumNumbers.add(inputNumber);
                continue;
            }
            sumNumbers.add(inputNumber + sumNumbers.get(count - 1));
        }

        for (int count = 0; count < answerCount; count++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            if (start == end) {
                int answer = inputNumbers.get(end - 1);
                answers.add(answer);
                continue;
            }

            int answer = sumNumbers.get(end - 1);
            if (start == 1) {
                answers.add(answer);
            } else {
                answers.add(answer - sumNumbers.get(start - 2));
            }
        }

        answers.forEach(System.out::println);
    }
}
