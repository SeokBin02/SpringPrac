package com.sparta.boardsb.controller;

import com.sparta.boardsb.dto.BoardRequestDTO;
import com.sparta.boardsb.dto.BoardResponseDTO;
import com.sparta.boardsb.entity.Post;
import com.sparta.boardsb.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/api/showAll")
    public List<BoardResponseDTO> showAll(){
        return boardService.getAllPost();
    }

    @PostMapping("/api/post")
    public Post createPost(@RequestBody BoardRequestDTO boardRequestDTO){
        return boardService.createPost(boardRequestDTO);
    }

    @GetMapping("/api/post/{id}")
    public BoardResponseDTO lookUpAPost(@PathVariable Long id){
        return boardService.lookUpAPost(id);
    }

    @PutMapping("/api/post/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody BoardRequestDTO requestDTO){
        return boardService.updatePost(id, requestDTO);
    }

    @DeleteMapping("/api/post/{id}")
    public String deletePost(@PathVariable Long id, @RequestBody BoardRequestDTO requestDTO){
        return boardService.deletePost(id, requestDTO);
    }
}
