package com.sparta.boardsb.dto;

import lombok.Getter;

@Getter
public class BoardRequestDTO {
    private String title;
    private String writer;
    private String password;
    private String content;
}
