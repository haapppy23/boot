package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;


@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Question> questionlist = this.questionRepository.findAll();
		model.addAttribute("questionList", questionlist);
		return "question_list";
		}
	
	@GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
	
	@GetMapping("/create")
	public String questionCerate() {
		return "question_form";
	}
	
	@PostMapping("/create")
	public String quesstionCreate(@RequestParam(value="subject")String subject,
									@RequestParam(value="content")String content) {
		
		this.questionService.create(subject, content);
		return "redirect:/question/list";
	}
	
	@GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
       questionService.delete(id);
        return "redirect:/question/list";
    }
	
}
