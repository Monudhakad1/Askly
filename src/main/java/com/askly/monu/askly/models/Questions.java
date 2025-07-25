package com.askly.monu.askly.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Questions extends BaseModel {

    private String title;

    private String content;


    private Set<Tag> tags;

    private User user;
}
