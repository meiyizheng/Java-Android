package com.example.meiyizheng.braintrainer2;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.String;

import com.example.meiyizheng.braintrainer2.R;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int locationOfCorrect;
    TextView resultTextView;
    int score=0;
    int numberOfQuestions = 0;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    ConstraintLayout gameLayout;



    Button goButton;
    ArrayList<Integer> answer = new ArrayList<Integer>();
    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.timerTextView));
    }


    public void newQuestion() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+" + " + Integer.toString(b));

        locationOfCorrect =  rand.nextInt(4);

        answer.clear();
        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrect)  {
                answer.add(a+b);
            } else{
                int wrongAnswer = rand.nextInt(41);

                while (wrongAnswer == a+b)  {
                    wrongAnswer =  rand.nextInt(41);
                }
                answer.add(wrongAnswer);
            }

        }

        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));

    }

    public void chooseAnswer(View view) {



            if (Integer.toString(locationOfCorrect).equals(view.getTag().toString())) {
                resultTextView.setText("Correct!");
                score++;

            } else {
                resultTextView.setText("Wrong :(");
            }
            numberOfQuestions++;
            scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
            newQuestion();


    }

    public void playAgain(View view) {
        playAgainButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score) + "/"+Integer.toString(numberOfQuestions));
        newQuestion();
        playAgainButton.setVisibility(View.INVISIBLE);
        resultTextView.setText("");
        new CountDownTimer(30100,1000) {

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Done!");
                playAgainButton.setVisibility(View.VISIBLE);
                gameLayout.setVisibility(View.INVISIBLE);

            }
        }.start();






    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         sumTextView = findViewById(R.id.sumTextView);


         button0 = findViewById(R.id.button0);
         button1 = findViewById(R.id.button1);
         button2 = findViewById(R.id.button2);
         button3 = findViewById(R.id.button3);

        resultTextView = findViewById(R.id.resultTextView);
        goButton = findViewById(R.id.goButton);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        playAgainButton = findViewById(R.id.playAgainButton);

        goButton.setVisibility(View.VISIBLE);

        gameLayout = findViewById(R.id.gameLayout);
        scoreTextView.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);

    }
}
