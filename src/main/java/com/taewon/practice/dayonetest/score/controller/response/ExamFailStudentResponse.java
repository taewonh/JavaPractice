package com.taewon.practice.dayonetest.score.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExamFailStudentResponse {

    private final String studentName;
    private final Double avgScore;
}
