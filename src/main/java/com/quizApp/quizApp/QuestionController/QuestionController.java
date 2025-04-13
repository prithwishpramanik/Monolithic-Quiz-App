package com.quizApp.quizApp.QuestionController;


import com.quizApp.quizApp.model.Question;
import com.quizApp.quizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("getAllQuestion")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("catagory/{CAT}")
    public ResponseEntity<List<Question>> getQuestionByCatagory(@PathVariable String CAT){
        return questionService.getQuestionByCatagory(CAT);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String>addQuestions(@RequestBody Question question){
           return questionService.addQuestion(question);
    }

}
