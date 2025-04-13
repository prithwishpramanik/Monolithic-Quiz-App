package com.quizApp.quizApp.Service;

import com.quizApp.quizApp.model.Question;

import com.quizApp.quizApp.DAO.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestion() {
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuestionByCatagory(String cat) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(cat),HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.CONFLICT);
        }
    }
}
