package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * This displays a general science test
 */

public class MainActivity extends AppCompatActivity {
    int answer1_score;
    int answer2_score;
    int answer3_score;
    int answer4_score;
    int answer5_score;
    int final_score;
    // Question 1
    RadioButton question1_choice3;
    // Question 2
    EditText question2_answer;
    // Question 3
    CheckBox question3_choice1;
    CheckBox question3_choice2;
    CheckBox question3_choice3;
    CheckBox question3_choice4;
    // Question 4
    RadioButton question4_choice2;
    // Question 5
    EditText question5_answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when submitAnswers butten is clicked
     */
    public void submitAnswers(View v) {
        // Get candidates name
        EditText nameText = (EditText) findViewById(R.id.name_field);
        String name = nameText.getText().toString();
        // show toast if candidate name is is empty
        if (nameText.getText().toString().equals("")) {
            Context context = getApplicationContext();
            CharSequence text = "Please input you name before submitting";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        // Question 1 answer
        boolean answer1;
        RadioButton question1_choice3 = findViewById(R.id.question1_choice3);
        answer1 = question1_choice3.isChecked();
        //Verify answer and award score for question 1
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }
        // Question 2 answer
        String answer2;
        EditText question2_answer = (EditText) this.findViewById(R.id.question2_answer);
        answer2 = question2_answer.getText().toString().toLowerCase();
        //Verify answer answer and award score for question 2
        if (answer2.equals("liver ")) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }
        // Question 3 answers
        boolean answer3_choice1;
        CheckBox question3_choice1 = this.findViewById(R.id.question3_choice1);
        answer3_choice1 = question3_choice1.isChecked();

        boolean answer3_choice2;
        CheckBox question3_choice2 = this.findViewById(R.id.question3_choice2);
        answer3_choice2 = question3_choice2.isChecked();

        boolean answer3_choice3;
        CheckBox question3_choice3 = this.findViewById(R.id.question3_choice3);
        answer3_choice3 = question3_choice3.isChecked();

        boolean answer3_choice4;
        CheckBox question3_choice4 = this.findViewById(R.id.question3_choice4);
        answer3_choice4 = question3_choice4.isChecked();

        //Verify answer answer and award score for question 3
        if (answer3_choice1 && !answer3_choice2 && answer3_choice3 && !answer3_choice4) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }

        // Question 4 answer
        boolean answer4;
        question4_choice2 = (RadioButton) this.findViewById(R.id.question4_choice2);
        answer4 = question4_choice2.isChecked();

        //Verify answer answer and award score for question 4
        if (answer4) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }

        // Question 5 Answer
        String answer5;
        EditText question5_answer = this.findViewById(R.id.question5_answer);
        answer5 = question5_answer.getText().toString().toLowerCase();
        if (answer5.equals("candela ")) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }
        //calculate and display candidate score
        String displayResult;

        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;
        if (final_score == 5) {
            displayResult = "Hi " + name + "Excellent " + "You scored " + final_score + " out of 5";
        } else if (final_score >= 3) {
            displayResult = "Almost there " + name + "You scored " + final_score + " out of 5"; } else {
            displayResult = "Try again, " + name + " You scored " + final_score + " out of 5";
        }

        Context context = getApplicationContext();
        CharSequence text = displayResult;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

