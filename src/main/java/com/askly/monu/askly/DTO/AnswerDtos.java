package com.askly.monu.askly.DTO;

import lombok.Data;

import java.util.Set;
@Data
public class AnswerDtos {
    private Long id;
    private String content;
    private Long userId;
    private Long questionId;
}
