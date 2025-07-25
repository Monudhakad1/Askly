package com.askly.monu.askly.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Comments extends BaseModel{
    //One answer have many comments

    private String content ;

    @ManyToOne
    @JoinColumn(name= "answer_id")
    private Answer answer; // this is the answer which has having this comment

    @ManyToOne
    @JoinColumn(name="parent_comment_id")
    private Comments parentComment; // Mains comment

    @OneToMany(mappedBy = "parentComment")
    private Set<Comments> replies; // replies of comments

    @ManyToMany
    @JoinTable(
            name="comment_likes",
            joinColumns = @JoinColumn(name="comment_id") ,
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private Set<User>likedBy ;






}
