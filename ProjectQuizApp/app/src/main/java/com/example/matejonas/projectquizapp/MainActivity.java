package com.example.matejonas.projectquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static int NUMBER_OF_QUESTIONS = 5;

    private int correctAnswers;

    private RadioGroup answer1;

    private RadioGroup answer4;

    private RadioGroup answer5;

    private CheckBox checkBox1;

    private CheckBox checkBox2;

    private CheckBox checkBox3;

    private EditText answer2;

    private Button button;

    private boolean submitted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1 = findViewById(R.id.answer_1);
        answer4 = findViewById(R.id.answer_4);
        answer5 = findViewById(R.id.answer_5);
        checkBox1 = findViewById(R.id.answer_3_1);
        checkBox2 = findViewById(R.id.answer_3_2);
        checkBox3 = findViewById(R.id.answer_3_3);
        answer2 = findViewById(R.id.answer_2);
        button = findViewById(R.id.button);
    }

    public void submit(View view) {
        if (submitted) {
            reset();
        } else {
            if (isFinished()) {
                submitted = true;
                button.setText("Reset");
                calculatePoints();
            }
        }
    }

    private void calculatePoints() {
        int answer1ButtonId = answer1.indexOfChild(answer1.findViewById(answer1.getCheckedRadioButtonId()));
        if (answer1ButtonId == 2) {
            correctAnswers++;
        }
        int answer4ButtonId = answer4.indexOfChild(answer4.findViewById(answer4.getCheckedRadioButtonId()));
        if (answer4ButtonId == 1) {
            correctAnswers++;
        }
        int answer5ButtonId = answer5.indexOfChild(answer5.findViewById(answer5.getCheckedRadioButtonId()));
        if (answer5ButtonId == 2) {
            correctAnswers++;
        }
        if (answer2.getText().toString().equalsIgnoreCase("Oreo")) {
            correctAnswers++;
        }
        if (checkBox1.isChecked() && !checkBox2.isChecked() && checkBox3.isChecked()) {
            correctAnswers++;
        }
        Toast.makeText(this, "You answered " + correctAnswers + " questions out of " + NUMBER_OF_QUESTIONS + " correctly!", Toast.LENGTH_LONG).show();
    }

    private void reset() {
        correctAnswers = 0;
        answer1.clearCheck();
        answer4.clearCheck();
        answer5.clearCheck();
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        answer2.setText("");
        submitted = false;
        button.setText("Submit");
        Toast.makeText(this, "The quiz was reset!", Toast.LENGTH_LONG).show();
    }

    private boolean isFinished() {
        if (answer1.getCheckedRadioButtonId() == -1 || answer4.getCheckedRadioButtonId() == -1 || answer5.getCheckedRadioButtonId() == -1 ||
                (!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked()) || answer2.getText().toString().equals("")) {
            Toast.makeText(this, "Please answer all questions!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
