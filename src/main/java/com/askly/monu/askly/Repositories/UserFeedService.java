package com.askly.monu.askly.Repositories;

import com.askly.monu.askly.models.Questions;
import com.askly.monu.askly.models.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserFeedService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private QuestionRepo questionRepo;

    public List<Questions> getUserFeed(Long userId , int page , int size) {
        User user = userRepo.findById(userId).orElseThrow(()-> new EntityNotFoundException("User not found"));
        Set<Long> tagIds = user.getFollowedTags().stream()
                .map(tag -> tag.getId())
                .collect(Collectors.toSet());

        return questionRepo.findQuestionsByTags(tagIds, org.springframework.data.domain.PageRequest.of(page, size)).getContent();
    }
}
