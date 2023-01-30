package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dictionary.models.Task;

import java.util.ArrayList;
import java.util.Random;

public class TestActivity extends AppCompatActivity {

    private TextView question;
    private Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;
    private ArrayList<Task> tasksList;
    Random random;
    int currentScore = 0;
    int questionAttempted = 0;
    int curretPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        question = findViewById(R.id.question);
        btnAnswer1 = findViewById(R.id.btn_answer1);
        btnAnswer2 = findViewById(R.id.btn_answer2);
        btnAnswer3 = findViewById(R.id.btn_answer3);
        btnAnswer4 = findViewById(R.id.btn_answer4);

        tasksList =new ArrayList<>();

        random = new Random();

        getTask(tasksList);
        curretPosition = random.nextInt(tasksList.size());
        setDataToView(curretPosition);

        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnAnswer1.getText().equals(tasksList.get(curretPosition).getTrueAnswer()))
                    currentScore++;
                questionAttempted++;
                curretPosition = random.nextInt(tasksList.size());
                setDataToView(curretPosition);
            }
        });

        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnAnswer2.getText().equals(tasksList.get(curretPosition).getTrueAnswer()))
                    currentScore++;
                questionAttempted++;
                curretPosition = random.nextInt(tasksList.size());
                setDataToView(curretPosition);
            }
        });

        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnAnswer3.getText().equals(tasksList.get(curretPosition).getTrueAnswer()))
                    currentScore++;
                questionAttempted++;
                curretPosition = random.nextInt(tasksList.size());
                setDataToView(curretPosition);
            }
        });

        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnAnswer4.getText().equals(tasksList.get(curretPosition).getTrueAnswer()))
                    currentScore++;
                questionAttempted++;
                curretPosition = random.nextInt(tasksList.size());
                setDataToView(curretPosition);
            }
        });




    }

    private void setDataToView(int curretPosition){
        question.setText(tasksList.get(curretPosition).getQuestion());

        btnAnswer1.setText(tasksList.get(curretPosition).getAnswer1());
        btnAnswer2.setText(tasksList.get(curretPosition).getAnswer2());
        btnAnswer3.setText(tasksList.get(curretPosition).getAnswer3());
        btnAnswer4.setText(tasksList.get(curretPosition).getAnswer4());


    }

    private void getTask(ArrayList<Task> tasksList){
        tasksList.add(new Task("Вопрос", "вариант ответа1", "вариант ответа2", "вариант ответа3","вариант ответа4", "вариант ответа3" ));
        tasksList.add(new Task("Вопрос", "вариант ответа1", "вариант ответа2", "вариант ответа3","вариант ответа4", "вариант ответа4" ));
        tasksList.add(new Task("Вопрос", "вариант ответа1", "вариант ответа2", "вариант ответа3","вариант ответа4", "вариант ответа2" ));
        tasksList.add(new Task("Вопрос", "вариант ответа1", "вариант ответа2", "вариант ответа3","вариант ответа4", "вариант ответа1" ));

    }
}