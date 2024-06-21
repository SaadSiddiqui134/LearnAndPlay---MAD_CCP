package com.example.mad_ccp;

import static com.example.mad_ccp.R.id.BackButtonFeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    EditText feedbackinput;
    Button btnBackFeed, btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        feedbackinput=findViewById(R.id.feedbackInputField);
        btnsubmit=findViewById(R.id.submitReviewButton);
        btnBackFeed=findViewById(BackButtonFeedback);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedback=feedbackinput.getText().toString();

                if(feedback==""){
                    Toast.makeText(Feedback.this, "No Feedback Entered", Toast.LENGTH_SHORT).show();
                    feedbackinput.setText("");
                }
                else {
                    Database db = new Database(getApplicationContext());
                    Intent intent1 = new Intent();
                    db.registerFeedback(feedback);
                    Toast.makeText(getApplicationContext(), "Feedback Recieved!", Toast.LENGTH_SHORT).show();
                    startActivity(intent1);
                }
            }
        });

    }
}