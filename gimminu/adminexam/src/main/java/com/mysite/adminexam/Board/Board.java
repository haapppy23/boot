package com.mysite.adminexam.Board;

import com.mysite.adminexam.Reply.Reply;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime date;

    @OneToMany(mappedBy = "board",cascade = CascadeType.REMOVE)
    private List<Reply> replylist;
}
