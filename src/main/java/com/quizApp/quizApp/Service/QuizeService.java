package com.quizApp.quizApp.Service;

import com.quizApp.quizApp.DAO.QuestionDao;
import com.quizApp.quizApp.DAO.QuizeDao;
import com.quizApp.quizApp.model.Question;
import com.quizApp.quizApp.model.QuestionWrapper;
import com.quizApp.quizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizeService {

    @Autowired
    QuizeDao quizeDao;

    @Autowired
    QuestionDao questionDAo;


    public ResponseEntity<String> CreateQuize(String category, int numQ, String title) {
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        List<Question> questions = questionDAo.getrandomQuestionsBycategory(category,numQ) ;
        quiz.setQuestions(questions);
        quizeDao.save(quiz);
        return new  ResponseEntity<>("success",HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {

        Optional<Quiz> quize = quizeDao.findById(id);
        List<Question> questionFromDB = quize.get().getQuestions();
        List<QuestionWrapper> quetionForUser = new ArrayList<>();
        for(Question q : questionFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            quetionForUser.add(qw);
        }

        return new ResponseEntity<>(quetionForUser,HttpStatus.OK);
    }
}
