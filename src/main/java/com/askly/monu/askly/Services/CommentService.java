package com.askly.monu.askly.Services;

import com.askly.monu.askly.DTO.CommentDto;
import com.askly.monu.askly.Repositories.AnswerRepository;
import com.askly.monu.askly.Repositories.CommentRepo;
import com.askly.monu.askly.models.Answer;
import com.askly.monu.askly.models.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private AnswerRepository answerRepo;

    public List<Comments> getCommentsByAnswerId(Long answerId,int page ,int size) {
        return commentRepo.findByAnswerId(answerId, PageRequest.of(page, size)).getContent();
    }

    public List<Comments> getRepliesByCommentId(Long commentId, int page, int size) {
        return commentRepo.findByParentCommentId(commentId, PageRequest.of(page, size)).getContent();
    }

    public Optional<Comments> getCommentById(Long id) {
        return commentRepo.findById(id);
    }

    public Comments createComment(CommentDto commentDto) {
        Comments comment = new Comments();
        comment.setContent(commentDto.getContent());


        Optional<Answer> answer = answerRepo.findById(commentDto.getAnswerId());
        answer.ifPresent(comment::setAnswer);
        if (commentDto.getParentCommentId() != null) {
            Optional<Comments> parentComment = commentRepo.findById(commentDto.getParentCommentId());
            parentComment.ifPresent(comment::setParentComment);
        }
        return commentRepo.save(comment);
    }
    public void deleteComment(Long id) {
        commentRepo.deleteById(id);
    }


}
