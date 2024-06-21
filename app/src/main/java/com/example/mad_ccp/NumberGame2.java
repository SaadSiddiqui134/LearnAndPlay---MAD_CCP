package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NumberGame2 extends AppCompatActivity {

    private EditText answer2NumInputField;
    private Button submitButton_num2, quitButton_num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_game2);

        answer2NumInputField = findViewById(R.id.answerNumInputField2);
        submitButton_num2= findViewById(R.id.submitButton2);


        submitButton_num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = answer2NumInputField.getText().toString().trim();
                if (!answer.isEmpty()) {
                    int userAnswer = Integer.parseInt(answer);
                    if (userAnswer == 6) {
                        // Correct answer
                        Toast.makeText(getApplicationContext(), "Correct answer!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(NumberGame2.this, NumberGame3.class);
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


    }


}
