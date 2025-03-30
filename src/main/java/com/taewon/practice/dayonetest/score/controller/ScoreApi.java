package com.taewon.practice.dayonetest.score.controller;

import com.taewon.practice.dayonetest.score.controller.request.SaveExamScoreRequest;
import com.taewon.practice.dayonetest.score.controller.response.ExamFailStudentResponse;
import com.taewon.practice.dayonetest.score.controller.response.ExamPassStudentResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreApi {

    @PutMapping("/exam/{exam}/score")
    public SaveExamScoreRequest save(@PathVariable("exam") String exam,
                                     @RequestBody SaveExamScoreRequest request) {
        return request;
    }

    @GetMapping("/exam/{exam}/pass")
    public List<ExamPassStudentResponse> pass(@PathVariable("exam") String exam) {
        return List.of(
                new ExamPassStudentResponse("taewon", 80.0)
        );
    }

    @GetMapping("/exam/{exam}/fail")
    public List<ExamFailStudentResponse> fail(@PathVariable("exam") String exam) {
        return List.of(
                new ExamFailStudentResponse("taewon", 20.0)
        );
    }
}
