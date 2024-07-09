package com.mysite.adminexam.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void createBoard(String title, String content) {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setDate(LocalDateTime.now());
        boardRepository.save(board);
    }
}
