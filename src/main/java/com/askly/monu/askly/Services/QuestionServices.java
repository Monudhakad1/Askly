package com.askly.monu.askly.Services;

import com.askly.monu.askly.DTO.QuestionDtos;
import com.askly.monu.askly.Repositories.QuestionRepo;
import com.askly.monu.askly.Repositories.TagRepo;
import com.askly.monu.askly.Repositories.UserRepo;
import com.askly.monu.askly.models.Questions;
import com.askly.monu.askly.models.Tag;
import com.askly.monu.askly.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServices {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TagRepo tagRepo;

    public List<Questions> getQuestions(int page , int size){
        return questionRepo.findAll(PageRequest.of(page, size)).getContent();
    }

    public Optional<Questions> getQuestionById(Long id){
        return questionRepo.findById(id);
    }
    public Questions createQuestion(QuestionDtos questionDto) {
        Questions question= new Questions();
        question.setTitle(questionDto.getTitle());
        question.setContent(questionDto.getContent());

        Optional<User> user= userRepo.findById(questionDto.getUserId());
        user.ifPresent(question::setUser);
        Set<Tag> tags = questionDto.getTagIds().stream()
                .map(tagRepo::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
        question.setTags(tags);
        return questionRepo.save(question);
    }
    public void deleteQuestion(Long id) {
        questionRepo.deleteById(id);
    }
}
