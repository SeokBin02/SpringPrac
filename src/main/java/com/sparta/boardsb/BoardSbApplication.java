package com.sparta.boardsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardSbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardSbApplication.class, args);
    }

}
