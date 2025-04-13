package com.quizApp.quizApp.QuestionController;

import com.quizApp.quizApp.Service.QuizeService;
import com.quizApp.quizApp.model.Question;
import com.quizApp.quizApp.model.QuestionWrapper;
import com.quizApp.quizApp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizeService quizeService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){

        return quizeService.CreateQuize(category,numQ,title);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id){
        return   quizeService.getQuiz(id);

    }

    @PostMapping("sumbit/{id}")
    public ResponseEntity<Integer> SubmitQuiz(@PathVariable Integer id,@RequestBody List<Response>responses){
        System.out.println("responsesPP: "+responses);
        return  quizeService.calculateResult(id,responses);
    }
}
