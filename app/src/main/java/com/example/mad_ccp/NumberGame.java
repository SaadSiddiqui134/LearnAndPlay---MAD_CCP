package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NumberGame extends AppCompatActivity {

    private EditText answerNumInputField;
    private Button submitButton_num, quitButton_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_game);

        answerNumInputField = findViewById(R.id.answerNumInputField);
        submitButton_num= findViewById(R.id.submitButton);
        quitButton_num = findViewById(R.id.nextButton);

        submitButton_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = answerNumInputField.getText().toString().trim();
                if (!answer.isEmpty()) {
                    int userAnswer = Integer.parseInt(answer);
                    if (userAnswer == 4) {
                        // Correct answer
                        Toast.makeText(getApplicationContext(), "Correct answer!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(NumberGame.this, NumberGame2.class);
                        startActivity(intent);
                    } else {
                        // Incorrect answer
                        Toast.makeText(getApplicationContext(), "Incorrect answer, try again!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please enter an answer!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        quitButton_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NumberGame.this, StudentPortal.class);
                startActivity(intent);
            }
        });
    }


}
