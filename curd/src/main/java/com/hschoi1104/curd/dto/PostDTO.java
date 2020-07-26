package com.hschoi1104.curd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PostDTO {
    private int seq;
    private String title;
    private String content;
    private String author;
    private int reads=0;
    private String deleted ="N";
}

