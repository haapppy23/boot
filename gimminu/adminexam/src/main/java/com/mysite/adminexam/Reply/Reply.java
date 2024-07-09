package com.mysite.adminexam.Reply;

import com.mysite.adminexam.Board.Board;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String author;
    private String content;

    private LocalDateTime date;

    @ManyToOne
    private Board board;
}
