package com.askly.monu.askly.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name="users") // Specify the table name in the database
public class User extends BaseModel{

    private String username;
    private String password;

    @ManyToMany
    @JoinTable(
            name="user_tag",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    private Set<Tag> followedTags;
}
