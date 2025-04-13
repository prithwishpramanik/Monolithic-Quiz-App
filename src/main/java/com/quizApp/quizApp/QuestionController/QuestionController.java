package com.quizApp.quizApp.QuestionController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api")
public class QuestionController {

    @GetMapping("getAllQuestion")
    public String getAllQuestion(){
        return "hello";
    }

}
