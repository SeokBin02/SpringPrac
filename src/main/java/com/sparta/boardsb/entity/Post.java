package com.sparta.boardsb.entity;

import com.sparta.boardsb.dto.BoardRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor
public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    public Post(BoardRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.writer = requestDTO.getWriter();
        this.password = requestDTO.getPassword();
        this.content = requestDTO.getContent();
    }

    public void update(BoardRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.writer = requestDTO.getWriter();
        this.password = requestDTO.getPassword();
        this.content = requestDTO.getContent();
    }
}

