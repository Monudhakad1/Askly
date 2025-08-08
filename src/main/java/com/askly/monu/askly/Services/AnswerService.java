package com.askly.monu.askly.Services;

import com.askly.monu.askly.DTO.AnswerDtos;
import com.askly.monu.askly.Repositories.AnswerRepository;
import com.askly.monu.askly.Repositories.QuestionRepo;
import com.askly.monu.askly.Repositories.UserRepo;
import com.askly.monu.askly.models.Answer;
import com.askly.monu.askly.models.Questions;
import com.askly.monu.askly.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Answer> getAnswersByQuestionId(Long questionId, int page, int size) {
        return answerRepo.findByQuestionId(questionId, PageRequest.of(page, size)).getContent();
    }
    public Optional<Answer> getAnswerById(Long id) {
        return answerRepo.findById(id);
    }
    public Answer createAnswer(AnswerDtos answerDTO) {
        Answer answer = new Answer();
        answer.setContent(answerDTO.getContent());

        Optional<Questions> question = questionRepo.findById(answerDTO.getQuestionId());
        question.ifPresent(answer::setQuestion);

        Optional<User> user = userRepo.findById(answerDTO.getUserId());
        user.ifPresent(answer::setUser);
        return answerRepo.save(answer);
    }
    public void deleteAnswer(Long id) {
        answerRepo.deleteById(id);
    }
}
