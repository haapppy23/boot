package com.mysite.adminexam.Board;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/create")
    public String create() {
        return "create";
    }
    @PostMapping("/create")
    public String create(@RequestParam ("title") String title,
                         @RequestParam ("content") String content) {
        boardService.createBoard(title,content);
        return "readlist";
    }
}
