package com.askly.monu.askly.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Answer extends BaseModel{
    // One Question have many answers
}
