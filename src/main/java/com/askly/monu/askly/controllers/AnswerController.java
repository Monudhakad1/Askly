package com.askly.monu.askly.controllers;

import com.askly.monu.askly.DTO.AnswerDtos;
import com.askly.monu.askly.Services.AnswerService;
import com.askly.monu.askly.models.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {

    @Autowired
    public AnswerService answerService;

    @GetMapping("/question/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable("questionId") Long questionId , @RequestParam int page , @RequestParam int size) {
        return answerService.getAnswersByQuestionId(questionId , page , size);
    }
    @GetMapping("/{id}")
        public ResponseEntity<Answer> getAnswerById(@PathVariable("id") Long id ){
        Optional<Answer> answer = answerService.getAnswerById(id);
        return answer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

    @PostMapping
    public Answer createAnswer(@RequestBody AnswerDtos answerDtos) {
        return answerService.createAnswer(answerDtos);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable("id") Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
