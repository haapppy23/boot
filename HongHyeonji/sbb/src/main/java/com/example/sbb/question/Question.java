package com.example.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.example.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Question {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)  //자동 생성
	    private Integer id;

	    @Column(length = 200)
	    private String subject;

	    @Column(columnDefinition = "TEXT") //엄청 큰 텍스트 용량
	    private String content;

	    private LocalDateTime createDate;
	    
	    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) 
	    private List<Answer> answerList; 
	

}
