package com.askly.monu.askly.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Questions extends BaseModel {


    private String content;

    @ManyToMany
    @JoinTable(
        name = "questions_tags",
        joinColumns = @JoinColumn(name = "question_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )

    private Set<Tag> tags;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;
}
