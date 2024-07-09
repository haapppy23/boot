package com.mysite.sbb.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

@RequestMapping("/answer")
@Controller
public class AnswerController {
	@Autowired
	private QuestionService questionSerivce;
	@Autowired
	private AnswerService answerService;
	
	@PostMapping("/create/{id}")
	public String createAnwer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
		Question question = this.questionSerivce.getQuestion(id);
		
		this.answerService.create(question, content);
		
		return String.format("redirect:/question/detail/%s", id);
		
	}
}
