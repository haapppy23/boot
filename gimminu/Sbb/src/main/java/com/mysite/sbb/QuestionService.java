package com.mysite.sbb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private QuetionRepository quetionRepository;
}
