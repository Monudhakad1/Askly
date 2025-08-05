package com.askly.monu.askly.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Answer extends BaseModel{

    private String content;

    @ManyToOne
    @JoinColumn(name= "question_id")
    private Questions question;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

    @OneToMany(mappedBy = "answer")
    private Set<Comments> comments;

    @ManyToMany
    @JoinTable(
            name = "answer_likes",
            joinColumns = @JoinColumn(name = "answer_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> likedBy;
}
