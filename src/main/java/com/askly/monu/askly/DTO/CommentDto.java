package com.askly.monu.askly.DTO;

import lombok.Data;

import java.util.Set;
@Data
public class CommentDto {
    private Long id;
    private String content;
    private Long answerId;
    private Long parentCommentId;

}
