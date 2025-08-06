package com.askly.monu.askly.DTO;

import lombok.Data;

import java.util.Set;
@Data
public class QuestionDtos {
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private Set<Long> tagIds;
}
