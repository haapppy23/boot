package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionRepository questionRepository;
	
	
	@GetMapping("/")
	public String list(Model model) {
		List<Question> questionlist = this.questionRepository.findAll();
		model.addAttribute("questionList", questionlist);
		return "question_list";
		}
	
	
}
