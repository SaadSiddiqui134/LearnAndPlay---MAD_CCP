package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NumberGame3 extends AppCompatActivity {

    private EditText answer3NumInputField;
    private Button submitButton_num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_game3);

        answer3NumInputField = findViewById(R.id.answerNumInputField3);
        submitButton_num3 = findViewById(R.id.submitButton3);

        submitButton_num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = answer3NumInputField.getText().toString().trim();
                if (!answer.isEmpty()) {
                    int userAnswer = Integer.parseInt(answer);
                    if (userAnswer == 6) {
                        // Correct answer
                        Toast.makeText(getApplicationContext(), "Correct answer, The Game is Finished!!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(NumberGame3.this, StudentPortal.class);
                        startActivity(intent);

                        // Start NotificationService with a custom message
                        startService(new Intent(NumberGame3.this, NotificationClass.class));


                        //Start MusicService
                        startService(new Intent(NumberGame3.this, MusicService.class));

                    } else {
                        // Incorrect answer
                        Toast.makeText(getApplicationContext(), "Incorrect answer, try again!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter an answer!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
