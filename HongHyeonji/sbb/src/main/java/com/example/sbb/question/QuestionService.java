package com.example.sbb.question;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.sbb.DataNotFoundException;
import com.example.sbb.S3Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	private final S3Service s3Service;
	
	public Page<Question> getList(int page){
		List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return this.questionRepository.findAll(pageable);
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question>question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			throw new DataNotFoundException("question not found");
		}
	}
	
	 public void create(String subject, String content, MultipartFile file1, MultipartFile file2, MultipartFile file3 ) throws IOException {
		   Question q = new Question();
		   UUID uuid = UUID.randomUUID();
		   
		   if(file1!=null&&!file1.isEmpty()) {
				String fileName1 = uuid+"_"+file1.getOriginalFilename();
				s3Service.uploadFile(file1, fileName1);
				q.setImage1(fileName1);
		   }
			
			if(file2!=null&&!file2.isEmpty()) {
				uuid = UUID.randomUUID();
				String fileName2 = uuid+"_"+file2.getOriginalFilename();
				s3Service.uploadFile(file2, fileName2);
				q.setImage2(fileName2);
			}
			
			if(file3!=null&&!file3.isEmpty()) {
				uuid = UUID.randomUUID();
				String fileName3 = uuid+"_"+file3.getOriginalFilename();
				s3Service.uploadFile(file3, fileName3);
				q.setImage3(fileName3);
			}
			
			
	        q.setSubject(subject);
	        q.setContent(content);
	        q.setCreateDate(LocalDateTime.now());
	        this.questionRepository.save(q);
	    }
	 

}
